package com.example.riccandmorty.presentation.character.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.riccandmorty.R
import com.example.riccandmorty.presentation.destinations.CharacterScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun BottomNavBar(
    navigator: DestinationsNavigator
) {
    val selectedIndex = remember { mutableStateOf(0)}
    BottomNavigation(
        backgroundColor = Color.Black,
        elevation = 10.dp,
        contentColor = Color.Gray
    )
    {
       BottomNavigationItem(
           selectedContentColor= Color.White,
           unselectedContentColor = Color.White.copy(0.4f),
           selected = selectedIndex.value == 0,
           onClick = {
               navigator.navigate(CharacterScreenDestination)
           },
           icon = {
               Icon(
                   imageVector = Icons.Default.Home,
                   contentDescription = stringResource(R.string.home_page)
               )
           }
       )
        BottomNavigationItem(
            selectedContentColor= Color.White,
            unselectedContentColor = Color.White.copy(0.4f),
            selected = selectedIndex.value == 1,
            onClick = {
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = stringResource(R.string.home_page)
                )
            }
        )
        BottomNavigationItem(
            selectedContentColor= Color.White,
            unselectedContentColor = Color.White.copy(0.4f),
            selected = selectedIndex.value == 2,
            onClick = {
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = stringResource(R.string.home_page)
                )
            }
        )
    }
}

