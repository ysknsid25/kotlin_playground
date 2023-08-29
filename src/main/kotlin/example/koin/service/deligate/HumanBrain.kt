package example.koin.service.deligate

import java.lang.IllegalStateException

class HumanBrain(override val language: String) : Brain {
    override fun speak(): String {
        throw IllegalStateException("panic!!")
    }

    override fun see() {
        println("I see")
    }
}