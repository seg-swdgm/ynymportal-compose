package com.uryonym.ynymportal.task

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.uryonym.ynymportal.data.Task
import com.uryonym.ynymportal.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskIndexScreen(
    onAddTask: () -> Unit,
    onTaskClick: (Task) -> Unit,
    viewModel: TaskIndexViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "index") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddTask) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(id = R.string.add_task)
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            Text(text = "task index page")
        }
    }
}
