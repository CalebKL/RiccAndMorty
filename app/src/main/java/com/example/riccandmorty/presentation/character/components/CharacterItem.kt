package com.example.riccandmorty.presentation.character.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.riccandmorty.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterItem(
    modifier: Modifier,
    imageUrl:String,
    text: String,
    origin: String
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd,
    ){
        Surface(
            shape = RoundedCornerShape(20.dp)
        ){
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberImagePainter(
                    data = imageUrl,
                    builder = {
                        placeholder(R.drawable.ic_placeholder)
                        crossfade(true)
                    }
                ),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.image_background)
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f),
            color = Color.Black.copy(ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomEnd = 20.dp,
                bottomStart = 20.dp
            )
            ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                Text(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Origin",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = origin,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Status",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    color = Color.Black
                )

            }
        }
    }
}
