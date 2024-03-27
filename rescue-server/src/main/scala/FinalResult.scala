import eu.ace_design.island.arena.{Retrospective, Run}

object FinalResult extends Retrospective with Single {

  // mvn -q package exec:java -Dexec.mainClass=FinalResult

  override val outputDir = "championships/_retrospective"

  val premidterm: Set[Run] = Set(Mission01, Mission02, Mission03, Mission04)
  val postmidterm: Set[Run] = Set(Mission05, Mission06, Mission07, Mission08)

  override val weeks: Set[Run] = premidterm ++ postmidterm

  override def players =  all

  trigger

}
