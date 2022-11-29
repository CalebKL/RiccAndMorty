package com.example.riccandmorty.presentation.details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailItem(
    name:String,
    item: String
) {
    Row (
        verticalAlignment = Alignment.CenterVertically
            ){
        Text(
            text = "$name:",
            style = MaterialTheme.typography.subtitle1,
            maxLines = 1,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = item,
            style = MaterialTheme.typography.subtitle2,
            maxLines = 1,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun DetailItemPreview() {
    DetailItem(name = "Name", item = "Caleb")
}