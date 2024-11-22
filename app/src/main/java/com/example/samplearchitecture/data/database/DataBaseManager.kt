package com.example.samplearchitecture.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.samplearchitecture.data.model.local.SampleEntity

@Database(
    entities = [SampleEntity::class],
    version = DataBaseManager.DATABASE_VERSION,
    exportSchema = false
)
abstract class DataBaseManager : RoomDatabase() {
    abstract fun getSampleDao(): SampleDao

    companion object {
        const val DATABASE_NAME = "SampleDataBase"
        const val DATABASE_VERSION = 1
    }
}