import eu.ace_design.island.arena.Run
import eu.ace_design.island.bot.IExplorerRaid
import eu.ace_design.island.game.{Directions, Plane}
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.resources.Resource
import eu.ace_design.island.stdlib.Resources._

object Mission03 extends Run with Cohort {


  override val number: String = "03"

  override val seed: Long                = Islands.s03
  override lazy val theIsland: IslandMap = Islands.week03

  override val crew: Int    = 15
  override val budget: Int  = 40000
  override val plane: Plane = Plane(1, 1, Directions.EAST)
  override val objectives: Set[(Resource, Int)] = Set((WOOD, 2000))

  override def players:  Map[String, Class[_ <: IExplorerRaid]] = all -
    "team101"  - "team112"  - "team122"  - "team206" - "team213"  - "team214"  - "team217"  - "team220"  - "team302"  - "team303"  - "team305"

}