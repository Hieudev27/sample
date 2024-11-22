package com.example.samplearchitecture.data.datasource.sample

import com.example.samplearchitecture.data.database.SampleDao
import com.example.samplearchitecture.data.model.Sample
import com.example.samplearchitecture.data.model.local.SampleEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SampleLocalDataSourceImpl(private val sampleDao: SampleDao) : SampleDataSource.Local {
    override suspend fun insert(sample: Sample) {
        val sampleEntity =
            SampleEntity(name = sample.name, description = sample.description)
        sampleDao.insert(sampleEntity)
    }

    override suspend fun getAllData(): Flow<List<Sample>> {
        return sampleDao.getAllData().map { sampleEntities ->
            sampleEntities.map { sampleEntity ->
                Sample(name = sampleEntity.name, description = sampleEntity.description)
            }
        }
    }
}