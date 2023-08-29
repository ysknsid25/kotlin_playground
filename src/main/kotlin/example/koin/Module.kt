package example.koin

import example.koin.controller.HelloController
import example.koin.service.HelloService
import example.koin.service.WorldService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object Module {
    val koinPracticeModules = module {
        //Service
        singleOf(::HelloService)
        singleOf(::WorldService)

        //Controller
        singleOf(::HelloController)
    }
}