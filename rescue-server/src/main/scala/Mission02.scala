import eu.ace_design.island.arena.Run
import eu.ace_design.island.bot.IExplorerRaid
import eu.ace_design.island.game.{Directions, Plane}
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.resources.Resource
import eu.ace_design.island.stdlib.Resources._

object Mission02 extends Run with Cohort {


  override val number: String = "02"

  override val seed: Long                = Islands.s02
  override lazy val theIsland: IslandMap = Islands.week02

  override val crew: Int    = 15
  override val budget: Int  = 25000
  override val plane: Plane = Plane(1, 1, Directions.EAST)
  override val objectives: Set[(Resource, Int)] = Set((WOOD, 2000))

  override def players:  Map[String, Class[_ <: IExplorerRaid]] = all - "team110" - "team214" - "team221" - "team306"

}