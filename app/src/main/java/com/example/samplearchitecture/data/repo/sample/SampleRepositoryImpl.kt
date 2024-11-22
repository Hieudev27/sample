package com.example.samplearchitecture.data.repo.sample

import com.example.samplearchitecture.data.datasource.sample.SampleDataSource
import com.example.samplearchitecture.data.model.Sample
import kotlinx.coroutines.flow.Flow

class SampleRepositoryImpl(private val sampleDataSource: SampleDataSource.Local) : SampleRepository {
    override suspend fun insert(sampleEntity: Sample) {
        sampleDataSource.insert(sampleEntity)
    }

    override suspend fun getAllData(): Flow<List<Sample>> {
        return sampleDataSource.getAllData()
    }
}