package eu.hnesoft.gameservice

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GameserviceApplicationTests @Autowired constructor(
	private val restTemplate: TestRestTemplate
){

	@Test
	fun contextLoads() {
	}
/*
	@Test
	fun `status should return message Server Ok!`() {

		val response = restTemplate.getForEntity(
			"http://localhost:8080/",
			GameServiceController::class.java
		)

		Assertions.assertEquals(200, response.statusCode.value())
		Assertions.assertNotNull(response.body)
		Assertions.assertEquals("Server Ok!", response.body?.message)
	}
	 */
}
