package example.koin.data

import org.jetbrains.exposed.sql.IColumnType
import org.jetbrains.exposed.sql.statements.api.ExposedConnection
import org.jetbrains.exposed.sql.statements.api.PreparedStatementApi
import java.sql.ResultSet

/**
 * ネイティブクエリはこのクラスを通して実行する
 */
class NativeQueryDataAccessor {
    private lateinit var statement: PreparedStatementApi;

    /**
     * ネイティブクエリを発行するのに必要な情報を準備する
     */
    fun prepareStatement(
        conn: ExposedConnection<*>,
        sql: String,
        args: Iterable<Pair<IColumnType, Any?>>,
        returnKeys: Boolean = true
    ) {
        //参考:returnKeysについて
        //https://docs.oracle.com/cd/E16338_01/java.112/b56281/jdbcvers.htm#CHDEGDHJ
        statement =
            conn.prepareStatement(sql, returnKeys)
        statement.fillParameters(args)
    }

    /**
     * 登録・更新・削除用のネイティブクエリを実行する
     */
    fun executeUpdate(): Int {
        return statement.executeUpdate()
    }

    /**
     * 検索用のネイティブクエリを実行する
     * Tはクエリの列を格納するデータクラスを想定
     */
    fun <T> executeQuery(fetch: (resultSet: ResultSet) -> T): List<T> {
        val resultSet = statement.executeQuery()
        val result = mutableListOf<T>()
        while (resultSet.next()) {
            val row = fetch(resultSet)
            result.add(row)
        }
        return result
    }

}
