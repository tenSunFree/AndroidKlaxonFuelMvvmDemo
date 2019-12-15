package com.home.androidklaxonfuelmvvmdemo.model.fuel.routing

import com.github.kittinunf.fuel.core.HeaderValues
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting

/**
 * internal 代表只有在相同的module內才可以使用這類別
 * sealed 聲明密封類
 */
internal sealed class MainFuelRouting : FuelRouting {

    private val taipeiCulturalAssetsPojoPath =
        "/apiAccess?scope=resourceAquire&rid=d40ee29c-a538-4a87-84f0-f43acfa19a20"

    class TaipeiCulturalAssetsPojo : MainFuelRouting()

    override val basePath: String = "https://data.taipei/opendata/datalist"

    override val method: Method
        get() {
            when (this) {
                is TaipeiCulturalAssetsPojo -> return Method.GET
            }
        }

    override val path: String
        get() {
            when (this) {
                is TaipeiCulturalAssetsPojo -> return taipeiCulturalAssetsPojoPath
            }
        }

    override val params: List<Pair<String, Any?>>?
        get() {
            when (this) {
                is TaipeiCulturalAssetsPojo -> return null
            }
        }

    override val bytes: ByteArray? = null

    override val body: String? = null

    override val headers: Map<String, HeaderValues>? = null
}