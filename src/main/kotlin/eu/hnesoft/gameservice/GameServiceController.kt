package eu.hnesoft.gameservice

import mu.KotlinLogging

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
class GameController {

	private val logger = KotlinLogging.logger {}

	val cases = mapOf(
		Pair(0, "Undefined!"),
		Pair(2, "Stone grinds scissors!"),
		Pair(3, "Paper covered stone!"),
		Pair(4, "Spock vaporizes stone!"),
		Pair(5,	"Stone crushes lizard!"), 
		Pair(6, "Scissors cut paper!"), 
		Pair(8,	"Spock smashes scissors!"),
		Pair(10, "Scissors decapitats lizard!"),
		Pair(12, "Paper refutes Spock!"), 
		Pair(15, "Lizard eats paper!"), 
		Pair(20, "Lizard poisons Spock!"))

	@GetMapping("/")
	fun checkResult(@RequestParam("symbolId") symbolId: Int): Response {
		logger.debug { "backend method has been called" }
		
		val choosenSymbol: Symbol? = Symbol.fromInt(symbolId)
		val randomSymbol: Symbol? = Symbol.fromInt((1 until 6).random())
		
		var resultMessage: String?
		if (choosenSymbol == randomSymbol) {
			resultMessage = cases.get(0)
		} else {
			resultMessage = checkCases(choosenSymbol, randomSymbol)
		}
		return Response(choosenSymbol, randomSymbol, resultMessage)
	}

	private fun checkCases(symbol1: Symbol?, symbol2: Symbol?): String? {
		if(symbol1 != null && symbol2 != null) {
			return cases.get(symbol1.rank*symbol2.rank)
		}
		return null
	}
}