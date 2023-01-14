package com.uryonym.ynymportal.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskIndexScreen(
    onTaskClick: () -> Unit,
    viewModel: TaskIndexViewModel = hiltViewModel()
) {
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
                Button(onClick = onTaskClick) {
                    Text(text = "Detailへ")
                }
            }
        }
    }
}