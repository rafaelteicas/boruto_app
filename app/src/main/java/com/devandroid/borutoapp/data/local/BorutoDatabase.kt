package com.devandroid.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devandroid.borutoapp.data.local.dao.HeroDao
import com.devandroid.borutoapp.data.local.dao.HeroRemoteKeysDao
import com.devandroid.borutoapp.domain.model.Hero
import com.devandroid.borutoapp.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}