package com.uryonym.ynymportal.task

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uryonym.ynymportal.R
import com.uryonym.ynymportal.data.Task
import com.uryonym.ynymportal.data.source.TasksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

// Ui State
data class EditTaskState (
    val title: String = "",
    val description: String = "",
    val is_complete: Boolean = false,
    val isLoading: Boolean = false,
    val userMessage: Int? = null,
    val isTaskSaved: Boolean = false
)

// ViewModel
@HiltViewModel
class TaskEditViewModel @Inject constructor(
    private val tasksRepository: TasksRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val taskId: String? = savedStateHandle["taskId"]

    private val _uiState = MutableStateFlow(EditTaskState())
    val uiState: StateFlow<EditTaskState> = _uiState.asStateFlow()

    fun saveTask() {
        if (uiState.value.title.isEmpty() || uiState.value.description.isEmpty()) {
            _uiState.update {
                it.copy(userMessage = R.string.empty_task_message)
            }
            return
        }

        if (taskId == null) {
            createNewTask()
        }
    }

    private fun createNewTask() = viewModelScope.launch {
        val newTask = Task(uiState.value.title, uiState.value.description)
        tasksRepository.saveTask(newTask)
        _uiState.update {
            it.copy(isTaskSaved = true)
        }
    }

}