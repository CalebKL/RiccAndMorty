package com.example.riccandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.riccandmorty.presentation.NavGraphs
import com.example.riccandmorty.presentation.ui.theme.RiccAndMortyTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RiccAndMortyTheme {
                DestinationsNavHost(navGraph = NavGraphs.root )
                Timber.plant(Timber.DebugTree())
            }
        }
    }
}
