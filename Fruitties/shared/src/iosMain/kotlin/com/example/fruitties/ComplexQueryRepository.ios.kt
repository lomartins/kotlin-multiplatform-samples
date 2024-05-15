package com.example.fruitties

import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.example.fruitties.database.AppDatabase

actual class ComplexQueryRepository actual constructor(private val database: AppDatabase, private val connection: SQLiteConnection) {
    actual suspend fun complexQuery(query: String): Any {
        return connection.prepare("SELECT * FROM Fruittie").also {
            val list = mutableListOf<Map<String, String?>>()

            while (it.step()) {
                val map = mutableMapOf<String, String?>()
                it.getColumnNames().forEachIndexed { index, column ->
                    map[column] = it.getText(index)
                }

                list.add(map)
                println("ComplexQueryRepository: $map")
            }
        }
    }
}