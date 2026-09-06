package com.clockapp.core.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clockapp.core.navigation.SecondaryRoutes

private data class MoreItem(val label: String, val route: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)

private val moreItems = listOf(
    MoreItem("Bedtime", SecondaryRoutes.BEDTIME, Icons.Filled.Nightlight),
    MoreItem("Settings", SecondaryRoutes.SETTINGS, Icons.Filled.Settings),
    MoreItem("Screen saver", SecondaryRoutes.SCREEN_SAVER, Icons.Filled.Tv),
    MoreItem("Help", SecondaryRoutes.HELP, Icons.Filled.Help),
    MoreItem("Feedback", SecondaryRoutes.FEEDBACK, Icons.Filled.Message),
    MoreItem("Privacy policy", SecondaryRoutes.PRIVACY_POLICY, Icons.Filled.Lock)
)

@Composable
fun MoreScreen(onNavigate: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
        moreItems.forEach { item ->
            ListItem(
                headlineContent = { Text(item.label) },
                leadingContent = { Icon(item.icon, contentDescription = null) },
                modifier = Modifier.clickable { onNavigate(item.route) }
            )
        }
    }
}
