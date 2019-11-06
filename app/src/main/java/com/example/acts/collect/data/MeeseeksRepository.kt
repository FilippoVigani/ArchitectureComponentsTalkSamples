package com.example.acts.collect.data

import android.content.Context
import androidx.room.Room
import com.example.acts.collect.data.entities.Meeseek
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MeeseeksRepository(private val context: Context) {

    private val database by lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "acts.db"
        ).build()
    }

    private val meeseekDao by lazy { database.meeseeksDao() }

    private suspend fun getLocalMeeseeks(count: Int): List<Meeseek>{
        return meeseekDao.loadFirst(count)
    }

    private suspend fun getRemoteMeeseeks(count: Int): List<Meeseek>{
        delay(2000)
        val meeseeks = (1..count).map {
            val purpose = when(it){
                1 -> "Teach Android Architecture Components"
                2 -> "Find your soul mate"
                3 -> "Convince me to start working out"
                else -> "Teach Jerry how to take two strokes off his golf game"
            }
            Meeseek(it, "Meeseek n° $it", purpose)
        }
        meeseekDao.insertAll(*meeseeks.toTypedArray())
        return meeseeks
    }


    fun getMeeseeks(count: Int): Flow<List<Meeseek>> = flow {
        emit(getLocalMeeseeks(count))
        emit(getRemoteMeeseeks(count))
    }
}