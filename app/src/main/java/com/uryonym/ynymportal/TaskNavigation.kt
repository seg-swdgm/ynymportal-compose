package com.uryonym.ynymportal

import androidx.navigation.NavHostController

class TaskNavigationActions(private val navController: NavHostController) {
    fun navigateToAddEditTask(taskId: String?) {
        if (taskId != null) {
            navController.navigate("taskEdit/taskId=$taskId")
        } else {
            navController.navigate("taskEdit")
        }
    }
}