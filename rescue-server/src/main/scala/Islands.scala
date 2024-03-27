import eu.ace_design.island.dsl.DiSLand
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.processes.AssignPitch
import eu.ace_design.island.stdlib.WhittakerDiagrams

object Islands extends DiSLand {

  val s01 = 0x161D552A4A22E2A1L
  lazy val week01: IslandMap = {
    createIsland shapedAs ellipsis(75.percent, 33.percent, 291) withSize 1600 having 2000.faces builtWith Seq(
      plateau(30), flowing(rivers = 5, distance = 0.4), withMoisture(soils.wet, distance = 300),
      AssignPitch, usingBiomes(WhittakerDiagrams.caribbean)) usingSeed s01
  }

  val s02 = 0x5B75D6CC8B576BD4L
  lazy val week02: IslandMap = {
    createIsland shapedAs donut(55.percent, 10.percent) withSize 1600 having 2000.faces builtWith Seq(
      plateau(15), flowing(rivers = 15, distance = 0.5), withMoisture(soils.wet, distance = 100),
      AssignPitch, usingBiomes(WhittakerDiagrams.caribbean)) usingSeed s02
  }

  val s03 = 0x5B75D6CC8B576BD4L
  lazy val week03: IslandMap = {
    createIsland shapedAs radial(factor = 0.78) withSize 1600 having 2000.faces builtWith Seq(
      plateau(30), flowing(rivers = 16, distance = 0.9), withMoisture(soils.normal, distance = 1000),
      AssignPitch, usingBiomes(WhittakerDiagrams.caribbean))  usingSeed s03
  }

  val s04 = 0x5B75D6FE8B586BD5L
  lazy val week04: IslandMap = {
    createIsland shapedAs radial(factor = 0.458) withSize 1600 having 2000.faces builtWith Seq(
      plateau(50), flowing(rivers = 22, distance = 0.78), withMoisture(soils.wet, distance = 300),
      AssignPitch, usingBiomes(WhittakerDiagrams.nordic))  usingSeed s04
  }

  val s05 = 0xDBFF90B43A359032L
  lazy val week05: IslandMap = {
    createIsland shapedAs radial(factor = 1.858) withSize 1600 having 2000.faces builtWith Seq(
      plateau(15), flowing(rivers = 22, distance = 0.78), withMoisture(soils.wet, distance = 800),
      AssignPitch, usingBiomes(WhittakerDiagrams.nordic))  usingSeed s05
  }

  val s06 = 0x40434AFE2AA7204EL
  lazy val week06: IslandMap = {
    createIsland shapedAs radial(factor = 1.658) withSize 1600 having 2000.faces builtWith Seq(
      plateau(15), flowing(rivers = 22, distance = 0.98), withMoisture(soils.wet, distance = 800),
      AssignPitch, usingBiomes(WhittakerDiagrams.caribbean))  usingSeed s06
  }

  val s07 = 0x71A47245AC318CDL
  lazy val week07: IslandMap = {
    createIsland shapedAs radial(factor = 0.42) withSize 1600 having 2000.faces builtWith Seq(
      plateau(40), flowing(rivers = 22, distance = 0.78), withMoisture(soils.normal, distance = 1000),
      AssignPitch, usingBiomes(WhittakerDiagrams.nordic))  usingSeed s07
  }


  val s08 = 0xDC17FDEC741110A3L
  lazy val week08: IslandMap = {
    createIsland shapedAs radial(factor = 0.64) withSize 1600 having 2000.faces builtWith Seq(
      plateau(50), flowing(rivers = 35, distance = 0.89), withMoisture(soils.wet, distance = 1000),
      AssignPitch, usingBiomes(WhittakerDiagrams.caribbean))  usingSeed s08
  }



}
