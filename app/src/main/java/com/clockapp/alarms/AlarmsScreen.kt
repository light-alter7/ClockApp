package com.clockapp.alarms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Placeholder in-memory model until Room entities are wired up. */
data class AlarmUi(
    val id: String,
    val time: String,
    val label: String,
    val repeatSummary: String,
    val enabled: Boolean
)

private val sampleAlarms = listOf(
    AlarmUi("1", "6:30 AM", "Workout", "Mon, Wed, Fri", enabled = true),
    AlarmUi("2", "8:00 AM", "", "Weekdays", enabled = true),
    AlarmUi("3", "11:45 PM", "Wind down", "Once", enabled = false)
)

@Composable
fun AlarmsScreen(onAddOrEditAlarm: (String?) -> Unit) {
    val alarms = remember { mutableStateOf(sampleAlarms) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Alarms") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { onAddOrEditAlarm(null) }) {
                Icon(Icons.Filled.Add, contentDescription = "Add alarm")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(alarms.value, key = { it.id }) { alarm ->
                AlarmCard(
                    alarm = alarm,
                    onToggle = { checked ->
                        alarms.value = alarms.value.map {
                            if (it.id == alarm.id) it.copy(enabled = checked) else it
                        }
                    },
                    onClick = { onAddOrEditAlarm(alarm.id) }
                )
            }
        }
    }
}

@Composable
private fun AlarmCard(alarm: AlarmUi, onToggle: (Boolean) -> Unit, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(alarm.time, style = androidx.compose.material3.MaterialTheme.typography.headlineSmall)
                val subtitle = if (alarm.label.isNotBlank()) "${alarm.label} · ${alarm.repeatSummary}" else alarm.repeatSummary
                Text(subtitle, style = androidx.compose.material3.MaterialTheme.typography.bodySmall)
            }
            Switch(checked = alarm.enabled, onCheckedChange = onToggle)
        }
    }
}
