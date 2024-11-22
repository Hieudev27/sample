package com.example.samplearchitecture.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.samplearchitecture.data.model.local.SampleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SampleDao {
    @Insert
    suspend fun insert(sampleEntity: SampleEntity)

    @Query("SELECT * FROM sample_table")
    fun getAllData(): Flow<List<SampleEntity>>
}