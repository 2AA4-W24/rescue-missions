import eu.ace_design.island.arena.Run
import eu.ace_design.island.bot.IExplorerRaid
import eu.ace_design.island.game.{Directions, Plane}
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.resources.Resource
import eu.ace_design.island.stdlib.Resources._

object Mission01 extends Run with Cohort {


  override val number: String = "01"

  override val seed: Long                = Islands.s01
  override lazy val theIsland: IslandMap = Islands.week01

  override val crew: Int    = 15
  override val budget: Int  = 30000
  override val plane: Plane = Plane(159, 159, Directions.NORTH)
  override val objectives: Set[(Resource, Int)] = Set((WOOD, 2000))

  override def players:  Map[String, Class[_ <: IExplorerRaid]] = all



}