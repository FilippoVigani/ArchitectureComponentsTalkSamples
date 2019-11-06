package com.example.acts.collect.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.acts.collect.data.dao.MeeseekDao
import com.example.acts.collect.data.entities.Meeseek

@Database(entities = [Meeseek::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun meeseeksDao(): MeeseekDao
}