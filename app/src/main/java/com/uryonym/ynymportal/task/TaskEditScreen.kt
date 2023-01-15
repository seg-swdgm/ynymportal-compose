package com.uryonym.ynymportal.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uryonym.ynymportal.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskEditScreen(
    onBack: () -> Unit, viewModel: TaskEditViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        TopAppBar(title = { Text("edit") })
    }, floatingActionButton = {
        FloatingActionButton(onClick = viewModel::saveTask) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = stringResource(id = R.string.save_task)
            )
        }
    }) { padding ->
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            OutlinedTextField(value = uiState.title, onValueChange = {})
            OutlinedTextField(value = uiState.description, onValueChange = {})
            Button(onClick = onBack) {
                Text(text = "Indexへ")
            }
        }
    }
}