package com.example.riccandmorty.presentation.details.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailsContent(
    onBackClicked: ()->Unit,
    imageUrl:String,
    title: String,
    status: String,
    species: String,
    gender: String,
    origin: String,
    location: String,

) {
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ){
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.65f)
                        .clip(shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)),
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
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    modifier = Modifier
                        .padding(start = 40.dp),
                    text =title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier= Modifier
                        .padding(start = 40.dp, top = 8.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                ){
                    Column{
                        DetailItem(name = stringResource(id = R.string.status), item = status)
                        Spacer(modifier = Modifier.height(8.dp))
                        DetailItem(name = stringResource(id = R.string.species), item =species)
                        Spacer(modifier = Modifier.height(8.dp))
                        DetailItem(name = stringResource(id = R.string.gender), item = gender)
                        Spacer(modifier = Modifier.height(8.dp))
                        DetailItem(name = stringResource(id = R.string.origin), item = origin)
                        Spacer(modifier = Modifier.height(8.dp))
                        DetailItem(name = stringResource(id = R.string.location), item = location)
                    }
                }
            }
        }
    )


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

