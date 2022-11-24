package com.example.riccandmorty.presentation.character.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
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
import com.example.riccandmorty.data.remote.models.CharacterDto

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterItem(
    modifier: Modifier,
    imageUrl:String,
    text: String,
    characters: CharacterDto,
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
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomEnd = 20.dp,
                bottomStart = 20.dp
            )
            ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ){
                Text(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Origin",
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 1,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = origin,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                )
                Text(
                    text = "Status",
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 1,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                StatusBar(characters = characters)

            }
        }
    }
}
