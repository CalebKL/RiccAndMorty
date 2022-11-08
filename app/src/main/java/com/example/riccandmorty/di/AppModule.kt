package com.example.riccandmorty.di

import android.content.Context
import androidx.room.Room
import com.example.riccandmorty.data.local.MortyDatabase
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.data.repository.character.local.CharacterLocalDataSource
import com.example.riccandmorty.data.repository.character.local.CharacterLocalImpl
import com.example.riccandmorty.data.repository.character.remote.CharacterRemoteDataSource
import com.example.riccandmorty.data.repository.character.remote.CharacterRemoteImp
import com.example.riccandmorty.data.repository.location.local.LocationLocalDataSource
import com.example.riccandmorty.data.repository.location.local.LocationLocalImpl
import com.example.riccandmorty.data.repository.location.remote.LocationRemoteDataSource
import com.example.riccandmorty.data.repository.location.remote.LocationRemoteImp
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Constants.BASE_URL
import com.example.riccandmorty.util.Constants.MORTY_DATABASE
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }
    @Provides
    @Singleton
    fun providesApi(okHttpClient: OkHttpClient): MortyApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MortyDatabase {
        return Room.databaseBuilder(
            context,
            MortyDatabase::class.java,
            MORTY_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterLocalDataSource(database:MortyDatabase ): CharacterLocalDataSource{
        return CharacterLocalImpl(database = database )
    }

    @Provides
    @Singleton
    fun provideLocationLocalDataSource(database:MortyDatabase ): LocationLocalDataSource{
        return LocationLocalImpl(database = database )
    }

    @Provides
    @Singleton
    fun provideCharacterRemoteDataSource(api: MortyApi): CharacterRemoteDataSource{
        return CharacterRemoteImp(api = api )
    }

    @Provides
    @Singleton
    fun provideLocationRemoteDataSource(api: MortyApi): LocationRemoteDataSource{
        return LocationRemoteImp(api = api )
    }
}



























