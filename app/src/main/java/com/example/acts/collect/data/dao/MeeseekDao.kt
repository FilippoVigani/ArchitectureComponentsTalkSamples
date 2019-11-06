package com.example.acts.collect.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.acts.collect.data.entities.Meeseek

@Dao
interface MeeseekDao {
    @Query("SELECT * FROM meeseek ORDER BY id ASC LIMIT :count")
    suspend fun loadFirst(count: Int): List<Meeseek>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg meeseeks: Meeseek)
}