package com.home.androidklaxonfuelmvvmdemo.model.room.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.home.androidklaxonfuelmvvmdemo.model.room.entity.TaipeiCulturalAssetsEntity

@Dao
interface TaipeiCulturalAssetsDao {

    @Query("SELECT * FROM taipei_cultural_assets LIMIT :max")
    fun getTaipeiCulturalAssetsList(max: Int): DataSource.Factory<Int, TaipeiCulturalAssetsEntity>

    @Insert(onConflict = REPLACE)
    fun insertTaipeiCulturalAssets(entity : TaipeiCulturalAssetsEntity)

    @Insert(onConflict = REPLACE)
    fun updateTaipeiCulturalAssetsList(list: List<TaipeiCulturalAssetsEntity>)

    @Update(onConflict = REPLACE)
    fun updateTaipeiCulturalAssets(entity : TaipeiCulturalAssetsEntity)
}