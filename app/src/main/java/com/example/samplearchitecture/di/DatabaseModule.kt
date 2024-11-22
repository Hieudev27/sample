package com.example.samplearchitecture.di

import android.content.Context
import androidx.room.Room
import com.example.samplearchitecture.data.database.DataBaseManager
import com.example.samplearchitecture.data.database.SampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DataBaseManager {
        return Room.databaseBuilder(
            context,
            DataBaseManager::class.java,
            "appDatabase.db"
        ).build()
    }
    @Provides
    fun provideSampleDao(database: DataBaseManager): SampleDao {
        return database.getSampleDao()
    }
}