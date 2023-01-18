package com.example.riccandmorty.presentation.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.riccandmorty.domain.use_case.GetCharacterDetailsUseCase
import com.example.riccandmorty.resource.fakeCharacterDto
import com.example.riccandmorty.util.Resource
import com.google.common.truth.Truth
import io.mockk.mockkClass
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class DetailsViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailsViewModel
    private var getCharacterDetailsUseCase:GetCharacterDetailsUseCase = mockkClass(GetCharacterDetailsUseCase::class)


    // WIP

//    @Test
//    fun `get character details, should return Error`()= runBlocking{
//        `when`(getCharacterDetailsUseCase.invoke(2)).thenReturn(
//            flow {
//                emit(Resource.Success(fakeCharacterDto))
//            }
//        )
//        viewModel = DetailsViewModel(getCharacterDetailsUseCase)
//        viewModel.onGetCharacterEvent(2)
//
//        val result = viewModel.onGetCharacterEvent(2)
//        Truth.assertThat(result).isSameInstanceAs(fakeCharacterDto)
//    }


}