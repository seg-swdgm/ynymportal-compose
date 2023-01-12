package com.uryonym.ynymportal.data.source

import com.uryonym.ynymportal.data.Result
import com.uryonym.ynymportal.data.Task
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class DefaultTasksRepository(
    private val tasksLocalDataSource: TasksDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TasksRepository {
    override fun getTasksStream(): Flow<Result<List<Task>>> {
        return tasksLocalDataSource.getTasksStream()
    }

    override fun getTaskStream(taskId: String): Flow<Result<Task>> {
        return tasksLocalDataSource.getTaskStream(taskId)
    }
}