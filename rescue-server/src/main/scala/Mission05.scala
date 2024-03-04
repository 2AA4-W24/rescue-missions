import eu.ace_design.island.arena.Run
import eu.ace_design.island.bot.IExplorerRaid
import eu.ace_design.island.game.{Directions, Plane}
import eu.ace_design.island.map.IslandMap
import eu.ace_design.island.map.resources.Resource
import eu.ace_design.island.stdlib.Resources._

object Mission05 extends Run with Cohort {


  override val number: String = "05"

  override val seed: Long                = scala.util.Random.nextLong()
  // override val seed: Long                = Islands.s05
  override lazy val theIsland: IslandMap = Islands.week05

  override val crew: Int    = 10
  override val budget: Int  = 20000
  override val plane: Plane = Plane(1, 1, Directions.EAST)
  override val objectives: Set[(Resource, Int)] = Set((WOOD, 2000))

  override val nbCreeks: Int = 17

  // override def players:  Map[String, Class[_ <: IExplorerRaid]] = Map()
  override def players:  Map[String, Class[_ <: IExplorerRaid]] = all - "team102" - "team111" - "team112" - "team113" - "team114" - "team206" - "team213" - "team214" - "team216" - "team102"- "team218" - "team219" - "team223" - "team304" - "team305"

}