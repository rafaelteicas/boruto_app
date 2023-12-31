package com.devandroid.borutoapp.data.local

import androidx.room.Database
import com.devandroid.borutoapp.data.local.dao.HeroDao
import com.devandroid.borutoapp.data.local.dao.HeroRemoteKeyDao
import com.devandroid.borutoapp.domain.model.Hero
import com.devandroid.borutoapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
abstract class BorutoDatabase {
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}