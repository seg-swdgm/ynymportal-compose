package com.uryonym.ynymportal

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uryonym.ynymportal.task.TaskDetailScreen
import com.uryonym.ynymportal.task.TaskIndexScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "taskIndex"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("taskIndex") {
            TaskIndexScreen(
                onTaskClick = { navController.navigate("taskDetail") }
            )
        }

        composable("taskDetail") {
            TaskDetailScreen(navController = navController)
        }
    }
}