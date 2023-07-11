package eu.hnesoft.gameservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class GameserviceApplication

val scissors: Int = 1
val rock: Int = 2
val paper: Int = 3
val spock: Int = 4
val lizard: Int = 5

fun main(args: Array<String>) {
	runApplication<GameserviceApplication>(*args)
}

@RestController
class GameController {

	val USER_WINS: String = "Sie haben gewonnen!"
	val PC_WINS: String = "Der PC hat gewonnen!"
	val DRAW_RESULT: String = "Unentschieden!"


	@GetMapping("/")
	fun play(@RequestParam("choice") usersChoice: Int): Message {
		var resultMessage: String = ""
		var computer = (1 until 6).random()
		if (usersChoice == Symbols.SCISSORS) {
			if (usersChoice == computer) {
				resultMessage = DRAW_RESULT
			} else if (computer == rock || computer == spock) {
				resultMessage = PC_WINS
			} else {
				resultMessage = USER_WINS
			}
		} else if (usersChoice == rock) {
			if (usersChoice == computer) {
				resultMessage = DRAW_RESULT
			} else if (computer == paper) {
				resultMessage = PC_WINS
			} else {
				resultMessage = USER_WINS
			}
		} else if (usersChoice == paper) {
			if (usersChoice == computer) {
				resultMessage = DRAW_RESULT
			} else if (computer == scissors) {
				resultMessage = PC_WINS
			} else {
				resultMessage = USER_WINS
			}
		} else if (usersChoice == spock) {
			if (usersChoice == computer) {
				resultMessage = DRAW_RESULT
			} else if (computer == paper || computer == lizard) {
				resultMessage = PC_WINS
			} else {
				resultMessage = USER_WINS
			}
		} else if (usersChoice == Symbols.LIZARD) {
			if (usersChoice == computer) {
				resultMessage = DRAW_RESULT
			} else if (computer == rock || computer == scissors) {
				resultMessage = PC_WINS
			} else {
				resultMessage = USER_WINS
			}
		}
		return Message(usersChoice, computer, resultMessage)
	}
}

enum class Symbols(val value: Int) {
	SCISSORS(1), ROCK(2), PAPER(3), SPOCK(4), LIZARD(5)

	companion object {
		private val map = Symbols.values().associateBy(Symbols::value)
		fun fromInt(type: Int) = map[type]
	}
}

data class Message(val usersChoice: Int, val computersChoice: Int, val result: String)
