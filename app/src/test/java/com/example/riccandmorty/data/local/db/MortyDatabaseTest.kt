package com.example.riccandmorty.data.local.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.riccandmorty.data.local.dao.CharacterDao
import com.example.riccandmorty.data.local.dao.CharacterRemoteDao
import com.example.riccandmorty.resource.fakeCharacterDto
import com.example.riccandmorty.resource.remoteKeys
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class MortyDatabaseTest {

    private lateinit var characterDao: CharacterDao
    private lateinit var characterRemoteDao: CharacterRemoteDao
    private lateinit var database: MortyDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context, MortyDatabase::class.java
        ).build()

        characterDao = database.characterDao()
        characterRemoteDao = database.characterRemoteDao()
    }

    @Test
    fun `store characters in morty database returns non null`() = runTest{
        characterDao.addCharacter(listOf(fakeCharacterDto))
        val characters = characterDao.getCharacters()
        Truth.assertThat(characters).isNotNull()
    }

    @Test
    fun `delete all characters in crypto database returns null`() = runTest{
        characterDao.addCharacter(listOf(fakeCharacterDto))
        characterDao.deleteAllCharacters()
        val characters = characterDao.getSelectedCharacter(9)
        Truth.assertThat(characters).isNull()
    }


    @Test
    fun `check if a character exists in the db`() = runTest{
        characterDao.addCharacter(listOf(fakeCharacterDto))
        val characters = characterDao.ifExists(333)
        Truth.assertThat(characters).isNotNull()
    }

    @Test
    fun `delete one character from morty db`() = runTest{
        characterDao.addCharacter(listOf(fakeCharacterDto))
        characterDao.deleteOneCharacter(111)
        val characters = characterDao.getSelectedCharacter(111)
        Truth.assertThat(characters).isNull()
    }

    @Test
    fun `saving remote keys to morty db and returns valid keys`() = runBlocking{
        characterRemoteDao.addAllRemoteKeys(listOf(remoteKeys))
        val key = characterRemoteDao.getRemoteKeys(1)
        Truth.assertThat(key).isNotNull()
        Truth.assertThat(key?.id).isEqualTo(1)
    }

    @Test
    fun `saving remote keys in morty db, clearing the db and return null`() = runBlocking {
        characterRemoteDao.addAllRemoteKeys(listOf(remoteKeys))
        characterRemoteDao.deleteAllRemoteKeys()
        val key = characterRemoteDao.getRemoteKeys(1)
        Truth.assertThat(key).isNull()
    }

    @After
    @Throws(IOException::class)
    fun tearDown(){
        database.close()
    }
}