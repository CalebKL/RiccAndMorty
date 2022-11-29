package com.example.riccandmorty.presentation.details

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.presentation.character.CharacterViewModel
import com.example.riccandmorty.presentation.details.components.DetailsContent
import com.example.riccandmorty.util.Resource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailsScreen(
    id:Int,
    navigator: DestinationsNavigator,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val detailsState = viewModel.state.collectAsState()
    LaunchedEffect(key1 = Unit){
        viewModel.onGetCharacterEvent(id)
    }
    if (detailsState.value.isLoading){
        CircularProgressIndicator()
    }else{
        DetailsContent(onBackClicked = {},
            imageUrl = "",
            title = "",
            status = "",
            species = "",
            gender = "",
            origin = "",
            location = "",
            firstEpisode ="" )
    }
}