package com.example.riccandmorty.presentation.character.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.riccandmorty.data.remote.models.CharacterDto

@Composable
fun StatusBar(
    characters: CharacterDto
) {
    Row(
        modifier = Modifier
    ){
        Canvas(modifier = Modifier
            .height(16.dp)
            .width(16.dp)){
            drawCircle(
                when (characters.status) {
                    "Alive" -> {
                        Color.Green
                    }
                    "Dead" -> {
                        Color.Red
                    }
                    else -> {
                        Color.Gray
                    }
                }
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = when (characters.status){
                "Alive" ->{
                    "Alive -"
                }
                "Dead" ->{
                    "Dead -"
                }
                else ->{
                    "Unknown -"
                }
        },
            style = MaterialTheme.typography.subtitle1,
            color = Color.White.copy(alpha = ContentAlpha.medium)
            )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = characters.species,
            color = Color.White.copy(alpha = ContentAlpha.medium)
        )
        Text(
            text = "("+characters.gender + ")",
            color = Color.White.copy(alpha = ContentAlpha.medium)
        )
    }
}
