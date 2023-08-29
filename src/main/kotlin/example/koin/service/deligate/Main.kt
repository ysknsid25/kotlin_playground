package example.koin.service.deligate

fun main(){
    val humanBrain = HumanBrain("English")
    val babyBrain = BabyBrain(humanBrain)
    babyBrain.speak()
    babyBrain.see()
}