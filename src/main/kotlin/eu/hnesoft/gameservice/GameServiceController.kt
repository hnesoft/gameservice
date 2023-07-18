package eu.hnesoft.gameservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin

@RestController
@CrossOrigin("http://localhost:4200")
class GameController {

	val USER_WINS: String = "Sie haben gewonnen!"
	val PC_WINS: String = "Der PC hat gewonnen!"
	val DRAW_RESULT: String = "Unentschieden!"

    val scissors: Int = 1
    val rock: Int = 2
    val paper: Int = 3
    val spock: Int = 4
    val lizard: Int = 5

	val resultMessages = listOf("Stone grinds scissors!","Scissors cut paper!", 
		"Scissors decapitats lizard!","Spock smashes scissors!",
        "Paper covered stone!","Stone crushes lizard!","Spock vaporizes stone!",
        "Lizard eats paper!","Paper refutes Spock!","Lizard poisons Spock!");

	@GetMapping("/")
	fun play(@RequestParam("choice") usersChoice: Int): Response {
		var resultMessage: String = ""
		var computer = (1 until 6).random()
		if (usersChoice == scissors) {
			if (usersChoice == computer) {
				resultMessage = DRAW_RESULT
			} else if (computer == rock) {
				resultMessage = resultMessages.get(0)
			} else if (computer == spock) {
				resultMessage = resultMessages.get(3)
			} else {
				resultMessage = resultMessages.get(usersChoice)
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
		} else if (usersChoice == lizard) {
			if (usersChoice == computer) {
				resultMessage = DRAW_RESULT
			} else if (computer == rock || computer == scissors) {
				resultMessage = PC_WINS
			} else {
				resultMessage = USER_WINS
			}
		}
		return Response(usersChoice, computer, resultMessage)
	}
}