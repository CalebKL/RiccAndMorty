package com.example.riccandmorty.presentation.character


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riccandmorty.data.repository.CharacterRepositoryImp
import com.example.riccandmorty.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepositoryImp
):ViewModel(){

    private val _characterListState: MutableState<CharacterState> = mutableStateOf(CharacterState())
    private val characterListState: State<CharacterState> = _characterListState


    private val handler = CoroutineExceptionHandler { _, exception ->
        _characterListState.value.isLoading = false
        _characterListState.value = CharacterState(
            error = exception.message!!
        )
    }

    fun getCharacters(){
        viewModelScope.launch(handler){

        }
    }
}