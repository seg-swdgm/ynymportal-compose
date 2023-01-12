package com.uryonym.ynymportal.ui.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskIndexScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = "index")
            })
        }) { padding ->
            Column(
                modifier = Modifier.padding(padding)
            ) {
                Text(text = "task index page")
                Button(onClick = { navController.navigate("taskDetail") }) {
                    Text(text = "Detailへ")
                }
            }
        }
    }
}