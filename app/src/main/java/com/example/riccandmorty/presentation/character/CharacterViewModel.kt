package com.example.riccandmorty.presentation.character


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.riccandmorty.domain.use_case.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
            val response = useCase().cachedIn(viewModelScope)
            _characterListState.value = CharacterState(
                characters = response
            )
        }
    }
}
