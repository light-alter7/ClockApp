package com.clockapp.timer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// TODO: multiple simultaneous timers, each with its own countdown + notification
@Composable
fun TimerScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text("Timer") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            Text("Timer list and creation flow go here")
        }
    }
}
