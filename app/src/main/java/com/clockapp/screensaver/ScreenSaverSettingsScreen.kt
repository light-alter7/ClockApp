package com.clockapp.screensaver

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// TODO: night-mode always-on display config (clock style, brightness, charging-only toggle)
@Composable
fun ScreenSaverSettingsScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text("Screen saver") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            Text("Screen saver style + trigger settings go here")
        }
    }
}
