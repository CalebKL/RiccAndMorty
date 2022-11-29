package com.example.riccandmorty.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riccandmorty.domain.use_case.GetCharacterDetailsUseCase
import com.example.riccandmorty.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCase: GetCharacterDetailsUseCase,
): ViewModel(){
    private val _state: MutableStateFlow<DetailsState> = MutableStateFlow(DetailsState())
    val state: StateFlow<DetailsState> = _state.asStateFlow()

    fun onGetCharacterEvent(id:Int){
        useCase(id).onEach {result->
            when(result){
                is Resource.Loading ->{
                    _state.value = DetailsState(
                        isLoading = true
                    )
                }
                is Resource.Success ->{
                    _state.value = DetailsState(
                        characters = result.data
                    )
                }
                is Resource.Error ->{
                    _state.value = DetailsState(
                        error = result.message!!
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}