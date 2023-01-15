package com.uryonym.ynymportal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uryonym.ynymportal.task.TaskEditScreen
import com.uryonym.ynymportal.task.TaskIndexScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "taskIndex",
    navActions: TaskNavigationActions = remember(navController) {
        TaskNavigationActions(
            navController
        )
    }
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("taskIndex") {
            TaskIndexScreen(
                onAddTask = { navActions.navigateToAddEditTask(null) },
                onTaskClick = { task -> navActions.navigateToAddEditTask(task.id) }
            )
        }

        composable("taskEdit") {
            TaskEditScreen(
                onBack = { navController.navigateUp() }
            )
        }
    }
}