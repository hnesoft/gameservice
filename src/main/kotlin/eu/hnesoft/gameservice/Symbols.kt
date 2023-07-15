package eu.hnesoft.gameservice

enum class Symbols(val value: Int) {
	SCISSORS(1), ROCK(2), PAPER(3), SPOCK(4), LIZARD(5);
/* 
    var value: Int = null
 
    constructor(){}

    constructor(value: Int){
        this.value = value
    }

	companion object {
		private val map = Symbols.values().associateBy(Symbols::value)
		fun fromInt(value: Int) = map[value]
	}
    */
}