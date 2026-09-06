package com.clockapp.worldclock

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// TODO: add/remove cities, live time-difference display
@Composable
fun WorldClockScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text("World clock") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            Text("City list with live times goes here")
        }
    }
}
