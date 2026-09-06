package com.clockapp.stopwatch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// TODO: start/pause/lap/reset with lap-time list
@Composable
fun StopwatchScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text("Stopwatch") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            Text("Stopwatch with lap times goes here")
        }
    }
}
