package com.uryonym.ynymportal.data.source.local

import com.uryonym.ynymportal.data.Result
import com.uryonym.ynymportal.data.Result.Success
import com.uryonym.ynymportal.data.Task
import com.uryonym.ynymportal.data.source.TasksDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class TasksLocalDataSource internal constructor(
    private val tasksDao: TasksDao, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TasksDataSource {
    override fun getTasksStream(): Flow<Result<List<Task>>> {
        return tasksDao.observeTasks().map {
            Success(it)
        }
    }

    override fun getTaskStream(taskId: String): Flow<Result<Task>> {
        return tasksDao.observeTaskById(taskId).map {
            Success(it)
        }
    }

    override suspend fun saveTask(task: Task) = withContext(ioDispatcher) {
        tasksDao.insertTask(task)
    }
}