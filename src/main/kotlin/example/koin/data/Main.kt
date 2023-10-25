package example.koin.data

import example.koin.data.model.Department
import example.koin.data.record.DepartmentRecord
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

fun main(){
    Database.connect(
        url = "jdbc:mysql://127.0.0.1:13306/exposed_local",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "exposer",
        password = "secret"
    )
    transaction {
        val nativeQueryDataAccessor = NativeQueryDataAccessor()
        nativeQueryDataAccessor.prepareStatement(
            TransactionManager.current().connection,
            """
                INSERT INTO DEPARTMENT VALUES (?, ?, SYSDATE(), SYSDATE())
            """.trimIndent(),
            listOf(
                Pair(Department.departmentId.columnType, 4),
                Pair(Department.departmentName.columnType, "法務', SYSDATE(), SYSDATE()); DELETE FROM DEPARTMENT; -- "),
            )
        )
        //実行
        nativeQueryDataAccessor.executeUpdate()
        commit()
    }
}