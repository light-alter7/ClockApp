package com.clockapp.help

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HelpScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text("Help") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            Text("FAQ / support content goes here")
        }
    }
}
