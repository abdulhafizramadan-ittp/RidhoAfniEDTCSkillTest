package com.ridhoafnidev.edtc.core_data.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ridhoafnidev.edtc.core_data.BuildConfig
import com.ridhoafnidev.edtc.core_data.data.local.entity.EventEntity

@Database(
    entities = [EventEntity::class],
    version = BuildConfig.schemaDatabaseVersion,
)

internal abstract class CoreDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}

