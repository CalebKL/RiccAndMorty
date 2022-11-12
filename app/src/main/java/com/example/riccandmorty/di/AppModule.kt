package com.example.riccandmorty.di

import android.content.Context
import androidx.room.Room
import com.example.riccandmorty.data.local.LocationConverter
import com.example.riccandmorty.data.local.MortyDatabase
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.data.repository.CharacterRepositoryImp
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.domain.use_case.GetAllCharactersUseCase
import com.example.riccandmorty.util.Constants.BASE_URL
import com.example.riccandmorty.util.Constants.MORTY_DATABASE
import com.example.riccandmorty.util.JsonParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
    fun provideCharacterRepository(database:MortyDatabase,api: MortyApi): CharacterRepository{
        return CharacterRepositoryImp(database = database, api = api)
    }

    @Provides
    @Singleton
    fun provideGetCharactersUseCase(repository: CharacterRepository): GetAllCharactersUseCase{
        return GetAllCharactersUseCase(repository = repository)
    }
}



























