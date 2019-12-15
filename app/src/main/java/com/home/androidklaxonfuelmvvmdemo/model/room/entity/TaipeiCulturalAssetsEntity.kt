package com.home.androidklaxonfuelmvvmdemo.model.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.home.androidklaxonfuelmvvmdemo.model.fuel.pojo.TaipeiCulturalAssetsPojo

@Entity(tableName = "taipei_cultural_assets")
class TaipeiCulturalAssetsEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = ""

    @ColumnInfo(name = "caseName")
    var caseName: String = ""

    @ColumnInfo(name = "registerDate")
    var registerDate: String = ""

    fun fromResults(result: TaipeiCulturalAssetsPojo.Result.Results): TaipeiCulturalAssetsEntity {
        id = result.id.toString()
        caseName = result.caseName
        registerDate = result.registerDate
        return this
    }

    companion object {
        fun fromTaipeiCulturalAssetsPojo(pojo: TaipeiCulturalAssetsPojo): List<TaipeiCulturalAssetsEntity> =
            pojo.result.results.map { results ->
                TaipeiCulturalAssetsEntity().fromResults(results)
            }
    }
}