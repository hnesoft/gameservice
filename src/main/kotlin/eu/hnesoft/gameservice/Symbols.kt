package eu.hnesoft.gameservice

enum class Symbols(val rank: Int) {
	SCISSORS(1), ROCK(2), PAPER(3), SPOCK(4), LIZARD(5);

	companion object {
		private val map = Symbols.values().associateBy(Symbols::rank)
		fun fromInt(value: Int) = map[value]
	}
}