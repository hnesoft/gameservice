package eu.hnesoft.gameservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GameserviceApplication

fun main(args: Array<String>) {
	runApplication<GameserviceApplication>(*args)
}
