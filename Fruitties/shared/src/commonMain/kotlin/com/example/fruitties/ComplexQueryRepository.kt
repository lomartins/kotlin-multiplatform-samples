package com.example.fruitties

import androidx.sqlite.SQLiteConnection
import com.example.fruitties.database.AppDatabase

expect class ComplexQueryRepository(
    database: AppDatabase,
    connection: SQLiteConnection
) {
    suspend fun complexQuery(query: String): Any
}