package com.example.riccandmorty.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator

@OptIn(ExperimentalPagingApi::class)
class BasePagingSource<V : Any>(
    private val totalPages: Int? = null,
    private val block: suspend (Int) -> List<V>
): RemoteMediator<Int, V>(){
    override suspend fun load(loadType: LoadType, state: PagingState<Int, V>): MediatorResult {

    }

}