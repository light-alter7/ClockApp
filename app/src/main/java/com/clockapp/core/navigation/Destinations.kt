package com.clockapp.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Timer
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * The five bottom-nav destinations, matching the v1 mockup:
 * Alarms, Timer, World Clock, Stopwatch, More.
 * "More" hosts Bedtime, Settings, Screen Saver, Help, Feedback, Privacy Policy.
 */
enum class TopLevelDestination(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    ALARMS("alarms", "Alarms", Icons.Filled.Alarm),
    TIMER("timer", "Timer", Icons.Filled.Timer),
    WORLD_CLOCK("world_clock", "Clock", Icons.Filled.Public),
    STOPWATCH("stopwatch", "Stopwatch", Icons.Filled.AccessTime),
    MORE("more", "More", Icons.Filled.MoreHoriz)
}

/** Secondary routes, reachable only from the More tab. */
object SecondaryRoutes {
    const val BEDTIME = "bedtime"
    const val SETTINGS = "settings"
    const val SCREEN_SAVER = "screen_saver"
    const val HELP = "help"
    const val FEEDBACK = "feedback"
    const val PRIVACY_POLICY = "privacy_policy"

    // Deeper flows off Alarms
    const val ALARM_EDIT = "alarm_edit"
    const val ALARM_EDIT_WITH_ID = "alarm_edit/{alarmId}"
}
