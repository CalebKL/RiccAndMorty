package com.example.riccandmorty.presentation.character


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riccandmorty.data.repository.CharacterRepositoryImp
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.domain.use_case.GetAllCharactersUseCase
import com.example.riccandmorty.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val useCase: GetAllCharactersUseCase
):ViewModel() {

    private val _characterListState: MutableState<CharacterState> = mutableStateOf(CharacterState())
    val characterListState: State<CharacterState> = _characterListState

    init {
        getCharacters()
    }
    private fun getCharacters() {
        viewModelScope.launch {
            useCase().onEach { result->
                when(result){
                    is Resource.Success ->{
                        _characterListState.value = CharacterState(
                            characters = result.data?: emptyList()
                        )
                    }
                    is Resource.Loading->{
                        _characterListState.value = CharacterState(isLoading = true)
                    }
                    is Resource.Error ->{
                        _characterListState.value = CharacterState(error = result.message?:" An unexpected Error Occurred")

                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}
