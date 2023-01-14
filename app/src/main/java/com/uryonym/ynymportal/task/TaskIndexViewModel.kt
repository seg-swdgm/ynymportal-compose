package com.uryonym.ynymportal.task

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.uryonym.ynymportal.data.source.TasksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskIndexViewModel @Inject constructor(
    private val tasksRepository: TasksRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}