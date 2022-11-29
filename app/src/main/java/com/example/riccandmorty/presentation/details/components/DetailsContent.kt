package com.example.riccandmorty.presentation.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
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
fun DetailsContent(
    onBackClicked: ()->Unit,
    imageUrl:String,
    title: String,
    status: String
    ) {
    TopAppBar(
        navigationIcon = {
            BackButton {
                onBackClicked()
            }
        },
        title = { Text(text = stringResource(id = R.string.details))}
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(0.5f),
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
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text =title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier= Modifier.padding(16.dp)
        ){
            Text(
                text =status,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
            )
        }
    }


}

@Composable
fun BackButton(
    onBackClicked: ()->Unit
) {
    IconButton(onClick = {
        onBackClicked()
    }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(R.string.arrow_back))
    }
}

