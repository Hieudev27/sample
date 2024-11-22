package com.example.samplearchitecture.data.datasource.sample

import com.example.samplearchitecture.data.model.Sample
import kotlinx.coroutines.flow.Flow

interface SampleDataSource {
    interface Local{
        suspend fun insert(sample: Sample)
        suspend fun getAllData(): Flow<List<Sample>>
    }
    interface Remote{
    }
}