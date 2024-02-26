#! /bin/bash

TAG=$1

if [ "$TAG" = "" ]
then
  echo "Missing tag identifier"
  exit 1
fi

echo "Using tag: ${TAG}\n"

ERROR=0

function main()
{
    for d in _deliveries/a2*
    do
        ID=`echo $d | rev | cut -d '-' -f 1 | rev`
        cd $d
        echo "# Processing Team ${ID} -- start"
        check_environment $ID
        if [ "$ERROR" = "1" ]
        then
            echo "# ABORT: Environment is not OK for rescue mission"
        else
            process_delivery $ID
        fi
        cd ../..
        echo "# Processing Team ${ID} -- end"
        echo
        ERROR=0
    done
}

function check_environment()
{
    checkout_tag $TAG
    git_tag_time
    xml_key_value pom.xml artifactId team${ID}
    exists_dir src/main/java/ca/mcmaster/se2aa4/island/team${ID}
    exists_file src/main/java/ca/mcmaster/se2aa4/island/team${ID}/Explorer.java
}


function process_delivery()
{
    count_loc
    maven install
    if [ "$ERROR" = "1" ]
        then
            echo "# ABORT: Code does not compile / Impossible to operate"
        else
            echo "# SUCCESSFUL DELIVERY FOR RESCUE MISSION!"
        fi
}


############### Functions ###################



ERROR=0

function checkout_tag()  # $1 is the expected tag
{
    echo -ne "# Checking out tag [$1]: "
    git checkout $1  > /dev/null 2> /dev/null
    if [ "$?" = "0" ]; then echo "OK"; else  ERROR=1 ; echo "FAILURE"; fi
}

function maven() # $1 is maven goal
{
    echo -ne "# Building using Maven [$1]: "
    mvn $1 > /dev/null 2> /dev/null
    STATUS=$?
    if [ "$STATUS" = "0" ]
    then
	echo "OK"
    else
	ERROR=1
	if [ "$STATUS" = "124" ]
	then
	    echo "TIMEOUT (compile time > 30s)"
	else
	    echo "FAILURE"
	fi
    fi
}

function build_git_stats() # $1 is project's id
{  ## Relies on git_stats tool
    echo "# Analyzing git activity"
    mkdir -p ../git_stats
    rm -rf ../git_stats/$1
    git_stats generate -p . -o ../git_stats/$1 -s 2> /dev/null
}

function count_loc() 
{ ## Relies on cloc
    echo -ne "# LOC counter [main]: " 
    cloc src/main 2> /dev/null | grep Java | tr -s '[:space:]' ' ' | cut -d " " -f 5
    echo -ne "# LOC counter [test]: " 
    cloc src/test 2> /dev/null | grep Java | tr -s '[:space:]' ' ' | cut -d " " -f 5
}


function exists_file()  #  $1  is file_name
{
    echo -ne "# Checking existence of [$1]: "
    if [ -s $1 ]; then echo "OK"; else ERROR=1 ; echo "FAILURE"; fi
}

function exists_regexp()
{
    echo -ne "# Checking existence of [$1]: "
    ls -1 | grep -i $1  > /dev/null 2> /dev/null
    if [ "$?" = "0" ]; then echo "OK"; else ERROR=1 ; echo "FAILURE"; fi
}

function exists_dir()  #  $1  is dir_name
{
    echo -ne "# Checking existence of [$1]: "
    if [ -s $1 ]; then echo "OK"; else ERROR=1 ; echo "FAILURE"; fi
}

function not_exists_dir()  #  $1  is dir_name
{
    echo -ne "# Checking non-existence of [$1]: "
    if [ -s $1 ]; then echo "FAILURE"; else echo "OK"; fi
}

function exists_pattern() # $1 = pattern, $2 = nickname
{
    echo -ne "# Checking existence of $2 [$1]: "
    find . -name "$1" | egrep '.*'  > /dev/null 2> /dev/null
    if [ "$?" = "0" ]; then echo "OK"; else ERROR=1 ; echo "FAILURE"; fi
}

function not_exists_pattern() # $1 = Directory, $2 = pattern, $3 = nickname
{
    echo -ne "# Checking non-existence of $2 [$1]: "
    find . -name "$1" | egrep '.*'  > /dev/null 2> /dev/null
    if [ "$?" = "0" ]; then echo "FAILURE"; else echo "OK"; fi
}


function log_time() 
{
    echo -ne "#  $1:"
    date "+%Y-%m-%d %H:%M:%S"
    echo
}


function git_tag_time()
{
    echo -ne "# Git stamp: "
    git log -n 1 $1 2> /dev/null | grep Date
    if [ "$?" != "0" ]; then echo ""; fi
}

function xml_key_value() # $1 file name. $2 node name, $3 expected value
{
    echo -ne "# $1/$2 == [$3]: "
    cat $1 | grep $2 | grep $3  > /dev/null 2> /dev/null
    if [ "$?" = "0" ]; then echo "OK"; else  ERROR=1 ; echo "FAILURE"; fi
}


############ Calling main

main
