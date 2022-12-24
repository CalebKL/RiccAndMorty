package com.example.riccandmorty.presentation.character

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.riccandmorty.presentation.character.components.BottomNavBar
import com.example.riccandmorty.presentation.character.components.CharacterItem
import com.example.riccandmorty.presentation.destinations.DetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import timber.log.Timber

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Destination(start = true)
fun CharacterScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state = viewModel.characterListState.value
    val characters = state.characters.collectAsLazyPagingItems()
    Timber.tag("Character").d(characters.loadState.toString())

   Scaffold(
       bottomBar = {
           BottomNavBar(navigator = navigator)
       },
       content = {
           LazyColumn(
               modifier = Modifier
                   .fillMaxSize(),
               verticalArrangement = Arrangement.spacedBy(8.dp)
           ) {
               items(characters) { character ->
                   CharacterItem(
                       modifier = Modifier
                           .height(380.dp)
                           .fillMaxWidth()
                           .clickable {
                               navigator.navigate(DetailsScreenDestination(
                                   id = character?.id!!,
                                   image = character.image,
                                   title = character.name,
                                   status = character.status,
                                   species =character.species ,
                                   gender = character.gender,
                                   origin = character.origin!!.name,
                                   location = character.location!!.name,
                               ))
                           },
                       imageUrl = character!!.image,
                       text = character.name,
                       origin = character.origin!!.name,
                       characters = character
                   )
               }
           }
       }
   )
}