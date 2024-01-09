package com.devandroid.borutoapp.data.repository

import androidx.paging.PagingData
import com.devandroid.borutoapp.domain.model.Hero
import com.devandroid.borutoapp.domain.repository.DataStoreOperations
import com.devandroid.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {
    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllData()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }
    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}