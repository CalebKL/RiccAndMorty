package com.example.riccandmorty.presentation.character

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.riccandmorty.presentation.character.components.CharacterItem
import com.ramcosta.composedestinations.annotation.Destination
import timber.log.Timber

@Composable
@Destination(start = true)
fun CharacterScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
) {

    val state = viewModel.characterListState.value
    val characters = state.characters.collectAsLazyPagingItems()
    Timber.tag("Character").d(characters.loadState.toString())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(characters) { character ->
            CharacterItem(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                imageUrl = character!!.image,
                text = character.name,
                origin = character.origin.name,
                characters = character
            )
        }
    }
}