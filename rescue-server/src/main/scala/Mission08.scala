import eu.ace_design.island.arena.Run
import eu.ace_design.island.bot.IExplorerRaid
import eu.ace_design.island.game.{Directions, Plane}
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.resources.Resource
import eu.ace_design.island.stdlib.Resources._

object Mission08 extends Run with Cohort {


  override val number: String = "08"

  // override val seed: Long                = scala.util.Random.nextLong()
  override val seed: Long                = Islands.s08
  override lazy val theIsland: IslandMap = Islands.week08

  override val crew: Int    = 10
  override val budget: Int  = 15000
  override val plane: Plane = Plane(1, 1, Directions.EAST)
  override val objectives: Set[(Resource, Int)] = Set((WOOD, 2000))

  override val nbCreeks: Int = 5

  // override def players:  Map[String, Class[_ <: IExplorerRaid]] = Map()
  override def players:  Map[String, Class[_ <: IExplorerRaid]] = all - "team102" - "team105"  - "team106"  - "team108"  - "team109"  - "team110"  - "team113"  - "team115"  - "team119"  - "team121"  - "team122"  - "team205"  - "team206"  - "team209"  - "team216"  - "team218"  - "team223"  - "team302"  - "team305"

}