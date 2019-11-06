package com.example.acts.collect.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meeseek")
data class Meeseek(
    @PrimaryKey val id: Int,
    val name: String,
    @ColumnInfo(name = "singular_purpose") val purpose: String
)