package com.example.riccandmorty.presentation.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.use_case.GetCharacterDetailsUseCase
import com.example.riccandmorty.presentation.character.CharacterState
import com.example.riccandmorty.util.Constants.DETAILS_ARGUMENT_KEY
import com.example.riccandmorty.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCase: GetCharacterDetailsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private val _state: MutableState<DetailsState> = mutableStateOf(DetailsState())
    val state: State<DetailsState> = _state
    val id = mutableStateOf(0)
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val characterId = savedStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            _state.value = DetailsState(isLoading = true)
            if (characterId != null){
                id.value = characterId
                getDetails(characterId)
            }
        }
    }
   private fun getDetails(id:Int){
      viewModelScope.launch {
          useCase(id).let {result ->
              when(result){
                  is Resource.Success ->{
                      _state.value = DetailsState(
                          characters = result.data
                      )
                  }
                  is Resource.Loading ->{
                      _state.value = DetailsState(
                          isLoading = true
                      )
                  }
                  is Resource.Error ->{
                      _state.value = DetailsState(
                          error = result.message?:"An Unexpected Error Occurred"
                      )
                  }
              }
          }
      }
   }

}