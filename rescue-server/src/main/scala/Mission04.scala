import eu.ace_design.island.arena.Run
import eu.ace_design.island.bot.IExplorerRaid
import eu.ace_design.island.game.{Directions, Plane}
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.resources.Resource
import eu.ace_design.island.stdlib.Resources._

object Mission04 extends Run with Cohort {


  override val number: String = "04"

  override val seed: Long                = Islands.s04
  override lazy val theIsland: IslandMap = Islands.week04

  override val crew: Int    = 15
  override val budget: Int  = 40000
  override val plane: Plane = Plane(1, 1, Directions.EAST)
  override val objectives: Set[(Resource, Int)] = Set((WOOD, 2000))

  // override def players:  Map[String, Class[_ <: IExplorerRaid]] = Map()
  override def players:  Map[String, Class[_ <: IExplorerRaid]] = all - "team109" - "team121" - "team122" - "team204" - "team206" - "team207" - "team306"

}