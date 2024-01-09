package com.devandroid.borutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.devandroid.borutoapp.data.local.BorutoDatabase
import com.devandroid.borutoapp.data.paging_source.HeroRemoteMediator
import com.devandroid.borutoapp.data.remote.BorutoApi
import com.devandroid.borutoapp.domain.model.Hero
import com.devandroid.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl (
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
): RemoteDataSource {
    private val heroDao = borutoDatabase.heroDao()

    override fun getAllData(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = 3),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
      TODO("FAZER ")
    }

}