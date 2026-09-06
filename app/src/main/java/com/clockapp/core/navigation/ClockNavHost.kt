package com.clockapp.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.clockapp.alarms.AlarmEditScreen
import com.clockapp.alarms.AlarmsScreen
import com.clockapp.bedtime.BedtimeScreen
import com.clockapp.feedback.FeedbackScreen
import com.clockapp.help.HelpScreen
import com.clockapp.core.ui.MoreScreen
import com.clockapp.privacy.PrivacyPolicyScreen
import com.clockapp.screensaver.ScreenSaverSettingsScreen
import com.clockapp.settings.SettingsScreen
import com.clockapp.stopwatch.StopwatchScreen
import com.clockapp.timer.TimerScreen
import com.clockapp.worldclock.WorldClockScreen

@Composable
fun ClockNavHost(navController: NavHostController = rememberNavController()) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            // Only show bottom bar on the 5 top-level destinations, not on secondary screens
            val topLevelRoutes = TopLevelDestination.values().map { it.route }
            if (currentRoute in topLevelRoutes) {
                NavigationBar {
                    TopLevelDestination.values().forEach { dest ->
                        NavigationBarItem(
                            selected = currentRoute == dest.route,
                            onClick = {
                                navController.navigate(dest.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { androidx.compose.material3.Icon(dest.icon, contentDescription = dest.label) },
                            label = { Text(dest.label) }
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = TopLevelDestination.ALARMS.route,
            modifier = androidx.compose.ui.Modifier.padding(padding)
        ) {
            composable(TopLevelDestination.ALARMS.route) {
                AlarmsScreen(onAddOrEditAlarm = { alarmId ->
                    val route = if (alarmId == null) SecondaryRoutes.ALARM_EDIT
                        else "alarm_edit/$alarmId"
                    navController.navigate(route)
                })
            }
            composable(TopLevelDestination.TIMER.route) { TimerScreen() }
            composable(TopLevelDestination.WORLD_CLOCK.route) { WorldClockScreen() }
            composable(TopLevelDestination.STOPWATCH.route) { StopwatchScreen() }
            composable(TopLevelDestination.MORE.route) {
                MoreScreen(onNavigate = { route -> navController.navigate(route) })
            }

            composable(SecondaryRoutes.ALARM_EDIT) { AlarmEditScreen(alarmId = null, onDone = { navController.popBackStack() }) }
            composable(SecondaryRoutes.ALARM_EDIT_WITH_ID) { backStackEntry ->
                val alarmId = backStackEntry.arguments?.getString("alarmId")
                AlarmEditScreen(alarmId = alarmId, onDone = { navController.popBackStack() })
            }

            composable(SecondaryRoutes.BEDTIME) { BedtimeScreen() }
            composable(SecondaryRoutes.SETTINGS) { SettingsScreen() }
            composable(SecondaryRoutes.SCREEN_SAVER) { ScreenSaverSettingsScreen() }
            composable(SecondaryRoutes.HELP) { HelpScreen() }
            composable(SecondaryRoutes.FEEDBACK) { FeedbackScreen() }
            composable(SecondaryRoutes.PRIVACY_POLICY) { PrivacyPolicyScreen() }
        }
    }
}
