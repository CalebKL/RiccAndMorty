package com.example.riccandmorty.presentation.character.components

sealed class CharacterUIEvent{
    object GetCharacters : CharacterUIEvent()
    data class SearchCharacters(val searchParams: String): CharacterUIEvent()
}
