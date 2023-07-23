package eu.hnesoft.gameservice

enum class Symbol(val rank: Int) {
	STONE(1), SCISSORS(2), PAPER(3), SPOCK(4), LIZARD(5);

	companion object {
		private val map = Symbol.values().associateBy(Symbol::rank)
		fun fromInt(value: Int): Symbol? = map[value]
	}
}
