package com.example.samplearchitecture.data.repo.sample

import com.example.samplearchitecture.data.model.Sample
import kotlinx.coroutines.flow.Flow

interface SampleRepository {
    suspend fun insert(sampleEntity: Sample)
    suspend fun getAllData(): Flow<List<Sample>>
}