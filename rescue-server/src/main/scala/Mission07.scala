import eu.ace_design.island.arena.Run
import eu.ace_design.island.bot.IExplorerRaid
import eu.ace_design.island.game.{Directions, Plane}
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.resources.Resource
import eu.ace_design.island.stdlib.Resources._

object Mission07 extends Run with Cohort {


  override val number: String = "07"

  // override val seed: Long                = scala.util.Random.nextLong()
  override val seed: Long                = Islands.s07
  override lazy val theIsland: IslandMap = Islands.week07

  override val crew: Int    = 10
  override val budget: Int  = 15000
  override val plane: Plane = Plane(1, 1, Directions.EAST)
  override val objectives: Set[(Resource, Int)] = Set((WOOD, 2000))

  override val nbCreeks: Int = 6

  // override def players:  Map[String, Class[_ <: IExplorerRaid]] = Map()
  override def players:  Map[String, Class[_ <: IExplorerRaid]] = all - "team105" - "team112" - "team105" - "team206" - "team212" - "team216" - "team218" - "team223" - "team301" - "team303" - "team305" - "team308"

}