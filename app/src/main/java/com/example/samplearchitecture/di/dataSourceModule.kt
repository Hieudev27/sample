package com.example.samplearchitecture.di

import com.example.samplearchitecture.data.database.SampleDao
import com.example.samplearchitecture.data.datasource.sample.SampleDataSource
import com.example.samplearchitecture.data.datasource.sample.SampleLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(sampleDao: SampleDao): SampleDataSource.Local {
        return SampleLocalDataSourceImpl(sampleDao)
    }
}