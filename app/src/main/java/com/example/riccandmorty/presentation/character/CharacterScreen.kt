package com.example.riccandmorty.presentation.character

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.riccandmorty.presentation.character.components.CharacterItem
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination(start = true)
fun CharacterScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
) {

    val state = viewModel.characterListState.value

    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(state.characters){character->
            CharacterItem(
                modifier = Modifier
                    .width(180.dp)
                    .height(200.dp),
                character = character
            )
        }
    }
}