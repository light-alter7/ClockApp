package com.clockapp.bedtime

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// TODO: bedtime schedule builds on the alarm engine once it exists
@Composable
fun BedtimeScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text("Bedtime") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            Text("Bedtime schedule setup goes here")
        }
    }
}
