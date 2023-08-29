package example.koin.service.deligate

class BabyBrain(private val humanBrain: HumanBrain): Brain by humanBrain {
    override fun speak(): String {
        println("gao gao : $language")
        return "gao gao"
    }
}