package com.example.samplearchitecture.di

import com.example.samplearchitecture.data.datasource.sample.SampleDataSource
import com.example.samplearchitecture.data.repo.sample.SampleRepository
import com.example.samplearchitecture.data.repo.sample.SampleRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTodoRepository(sampleDataSource: SampleDataSource.Local): SampleRepository {
        return SampleRepositoryImpl(sampleDataSource)
    }
}