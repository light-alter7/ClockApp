package com.clockapp.alarms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Dismiss mission types available per alarm, per the finalized v1 feature scope. */
enum class DismissMission(val label: String) {
    NONE("None"),
    MATH_PROBLEM("Math problem"),
    SHAKE("Shake to dismiss"),
    PHOTO_MATCH("Photo match"),
    QR_SCAN("Scan a QR code"),
    TYPE_PHRASE("Type a phrase")
}

@Composable
fun AlarmEditScreen(alarmId: String?, onDone: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (alarmId == null) "New alarm" else "Edit alarm") },
                actions = { TextButton(onClick = onDone) { Text("Save") } }
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(padding)) {
            item {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text("6:30 AM", style = androidx.compose.material3.MaterialTheme.typography.displayMedium)
                }
                Divider()
            }
            item { ListItem(headlineContent = { Text("Repeat") }, supportingContent = { Text("Mon, Wed, Fri") }) }
            item { ListItem(headlineContent = { Text("Label") }, supportingContent = { Text("Workout") }) }
            item { ListItem(headlineContent = { Text("Sound") }, supportingContent = { Text("Default · Volume 70%") }) }
            item { ListItem(headlineContent = { Text("Gradual volume ramp-up") }, supportingContent = { Text("Off") }) }
            item { ListItem(headlineContent = { Text("Vibration pattern") }, supportingContent = { Text("Default") }) }
            item { Divider() }
            item { ListItem(headlineContent = { Text("Snooze duration") }, supportingContent = { Text("10 minutes") }) }
            item { ListItem(headlineContent = { Text("Max snoozes") }, supportingContent = { Text("3, then harder dismiss mission") }) }
            item { ListItem(headlineContent = { Text("Dismiss mission") }, supportingContent = { Text(DismissMission.MATH_PROBLEM.label) }) }
            item { ListItem(headlineContent = { Text("Skip next occurrence") }, supportingContent = { Text("Off") }) }
            item { Divider() }
            item { ListItem(headlineContent = { Text("Link a music app") }, supportingContent = { Text("None") }) }
        }
    }
}
