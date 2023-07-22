package eu.hnesoft.gameservice

import mu.KotlinLogging

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin

@RestController
@CrossOrigin("http://localhost:4200")
class GameController {

	private val logger = KotlinLogging.logger {}

	val USER_WINS: String = "You win!"
	val PC_WINS: String = "The PC win!"
	val UNDECIDED: String = "Undecided!"

	val resultMessages = listOf("Stone grinds scissors!","Scissors cut paper!", 
		"Scissors decapitats lizard!","Spock smashes scissors!",
        "Paper covered stone!","Stone crushes lizard!","Spock vaporizes stone!",
        "Lizard eats paper!","Paper refutes Spock!","Lizard poisons Spock!");

	@GetMapping("/")
	fun checkResult(@RequestParam("choice") usersChoice: Int): Response {
		logger.debug { "backend method has been called" }
		var resultMessage: String = ""
		var computer = (1 until 6).random()
		if (usersChoice == Symbols.SCISSORS.rank) {
			if (computer == usersChoice) {
				resultMessage = UNDECIDED
			} else if (computer == Symbols.PAPER.rank || computer == Symbols.LIZARD.rank) {
				resultMessage = USER_WINS
			} else {
				resultMessage = PC_WINS
			}
		} else if (usersChoice == Symbols.ROCK.rank) {
			if (computer == usersChoice) {
				resultMessage = UNDECIDED
			} else if (computer == Symbols.SCISSORS.rank || computer == Symbols.LIZARD.rank) {
				resultMessage = USER_WINS
			} else {
				resultMessage = PC_WINS
			}
		} else if (usersChoice == Symbols.PAPER.rank) {
			if (computer == usersChoice) {
				resultMessage = UNDECIDED
			} else if (computer == Symbols.SPOCK.rank || computer == Symbols.ROCK.rank) {
				resultMessage = USER_WINS
			} else {
				resultMessage = PC_WINS
			}
		} else if (usersChoice == Symbols.SPOCK.rank) {
			if (computer == usersChoice) {
				resultMessage = UNDECIDED
			} else if (computer == Symbols.SCISSORS.rank || computer == Symbols.ROCK.rank) {
				resultMessage = USER_WINS
			} else {
				resultMessage = PC_WINS
			}
		} else if (usersChoice == Symbols.LIZARD.rank) {
			if (computer == usersChoice) {
				resultMessage = UNDECIDED
			} else if (computer == Symbols.SPOCK.rank || computer == Symbols.PAPER.rank) {
				resultMessage = USER_WINS
			} else {
				resultMessage = PC_WINS
			}
		}
		return Response(usersChoice, computer, resultMessage)
	}
}