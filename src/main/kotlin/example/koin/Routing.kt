package example.koin

import example.koin.controller.HelloController
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    // Koinがないとこうなる。コントローラー1個ならいいかもだが、増えていくと…
    //    val helloController = HelloController(
    //        HelloService(),
    //        WorldService()
    //    )
    val helloController by inject<HelloController>()

    routing {
        get("/") {
            helloController.printsHello()
            call.respondText("Hello World!")
        }
    }
}
