package com.uryonym.ynymportal.ui.task

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun TaskDetailScreen(navController: NavHostController) {
    Column {
        Text(text = "task detail page")
        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Indexへ")
        }
    }
}