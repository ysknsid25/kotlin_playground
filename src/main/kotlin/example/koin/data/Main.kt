package example.koin.data

import example.koin.data.model.Department
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun main(){
    Database.connect(
        url = "jdbc:mysql://127.0.0.1:13306/exposed_local",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "exposer",
        password = "secret"
    )
    transaction {
        Department.slice(Department.departmentId, Department.departmentName).selectAll().map {
            println("${it[Department.departmentId]}: ${it[Department.departmentName]}")
        }
    }
}