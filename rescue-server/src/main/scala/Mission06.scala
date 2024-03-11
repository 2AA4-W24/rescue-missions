import eu.ace_design.island.arena.Run
import eu.ace_design.island.bot.IExplorerRaid
import eu.ace_design.island.game.{Directions, Plane}
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.resources.Resource
import eu.ace_design.island.stdlib.Resources._

object Mission06 extends Run with Cohort {


  override val number: String = "06"

  // override val seed: Long                = scala.util.Random.nextLong()
  override val seed: Long                = Islands.s06
  override lazy val theIsland: IslandMap = Islands.week06

  override val crew: Int    = 10
  override val budget: Int  = 15000
  override val plane: Plane = Plane(1, 1, Directions.EAST)
  override val objectives: Set[(Resource, Int)] = Set((WOOD, 2000))

  override val nbCreeks: Int = 21

  // override def players:  Map[String, Class[_ <: IExplorerRaid]] = Map()
  override def players:  Map[String, Class[_ <: IExplorerRaid]] = all - "team105" - "team112" - "team113" - "team114" - "team121" - "team205" - "team206" - "team210" - "team212" - "team216" - "team218" - "team219" - "team223" - "team304" - "team305"

}