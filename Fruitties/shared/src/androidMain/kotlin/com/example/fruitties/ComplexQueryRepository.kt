package com.example.fruitties

import android.database.Cursor
import com.example.fruitties.database.AppDatabase

class ComplexQueryRepository(
    private var database: AppDatabase
) {

    suspend fun complexQuery(): Cursor {
        return database.openHelper.readableDatabase.query("SELECT * FROM Fruittie")
    }
}