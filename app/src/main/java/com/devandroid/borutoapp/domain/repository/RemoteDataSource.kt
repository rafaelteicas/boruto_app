package com.devandroid.borutoapp.domain.repository

import androidx.paging.PagingData
import com.devandroid.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllData(): Flow<PagingData<Hero>>
    fun searchHeroes(): Flow<PagingData<Hero>>
}