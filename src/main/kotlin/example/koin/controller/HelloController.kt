package example.koin.controller

import example.koin.service.HelloService
import example.koin.service.WorldService

class HelloController(
    private val helloService: HelloService,
    private val worldService: WorldService
) {
    fun printsHello() {
        helloService.printsHello()
        worldService.printsWorld()
        val data = listOf(
            listOf("a", 2),
            listOf("b", 3),
            listOf("a", 4)
        )
        val set = mutableSetOf<String>()
        val filterData = data.filter{
            set.add(it[0] as String)
        }

        var sum = 0
        filterData.map {
            sum += it[1] as Int
        }
        println(sum)
    }
}