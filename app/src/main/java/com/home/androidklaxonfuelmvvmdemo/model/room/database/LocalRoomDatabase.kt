package com.home.androidklaxonfuelmvvmdemo.model.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.home.androidklaxonfuelmvvmdemo.model.room.dao.TaipeiCulturalAssetsDao
import com.home.androidklaxonfuelmvvmdemo.model.room.entity.TaipeiCulturalAssetsEntity

@Database(entities = [(TaipeiCulturalAssetsEntity::class)], version = 1, exportSchema = false)
abstract class LocalRoomDatabase : RoomDatabase() {

    abstract fun taipeiCulturalAssetsDao(): TaipeiCulturalAssetsDao
}