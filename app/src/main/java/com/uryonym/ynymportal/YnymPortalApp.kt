package com.uryonym.ynymportal

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uryonym.ynymportal.ui.task.TaskDetailScreen
import com.uryonym.ynymportal.ui.task.TaskIndexScreen
import com.uryonym.ynymportal.ui.theme.YnymportalTheme

@Composable
fun YnymPortalApp() {
    val navController = rememberNavController()

    YnymportalTheme {
        NavHost(navController = navController, startDestination = "taskIndex") {
            composable("taskIndex") {
                TaskIndexScreen(navController = navController)
            }

            composable("taskDetail") {
                TaskDetailScreen(navController = navController)
            }
        }
    }
}