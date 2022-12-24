package com.example.riccandmorty.data.pagingsource

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.RemoteMediator
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.riccandmorty.data.local.dao.CharacterDao
import com.example.riccandmorty.data.local.db.MortyDatabase
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.resource.pagingState
import com.example.riccandmorty.resource.validCharacterResult
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@ExperimentalPagingApi
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class CharacterRemoteMediatorTest {

    private lateinit var characterDao: CharacterDao
    private lateinit var db: MortyDatabase
    private val apiService = mockk<MortyApi>()
    private lateinit var mediator: CharacterRemoteMediator

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, MortyDatabase::class.java
        ).build()

        characterDao = db.characterDao()
    }

    @Test
    fun `refresh load returns success with more data to load`() = runTest {
        coEvery { apiService.getCharacters(any()) } returns validCharacterResult

        val result = mediator.load(LoadType.REFRESH, pagingState)

        assertThat(result).isInstanceOf(RemoteMediator.MediatorResult.Success::class.java)
        assertThat((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached).isFalse()
    }
}