package com.example.riccandmorty.presentation.character.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    search:String,
    onSearchClicked:(String)->Unit,
    onCloseClick:()->Unit,
    onTextChanged:(String)->Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = Color.LightGray,
        elevation = AppBarDefaults.TopAppBarElevation
    ){

    }
}