package com.uryonym.ynymportal.di

import android.content.Context
import androidx.room.Room
import com.uryonym.ynymportal.data.source.DefaultTasksRepository
import com.uryonym.ynymportal.data.source.TasksDataSource
import com.uryonym.ynymportal.data.source.TasksRepository
import com.uryonym.ynymportal.data.source.local.TaskDatabase
import com.uryonym.ynymportal.data.source.local.TasksLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalTasksDataSource

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideTasksRepository(
        @LocalTasksDataSource localDataSource: TasksDataSource,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): TasksRepository {
        return DefaultTasksRepository(localDataSource, ioDispatcher)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @LocalTasksDataSource
    @Provides
    fun provideTasksLocalDataSource(
        database: TaskDatabase,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): TasksDataSource {
        return TasksLocalDataSource(database.taskDao(), ioDispatcher)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): TaskDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TaskDatabase::class.java,
            "Tasks.db"
        ).build()
    }
}