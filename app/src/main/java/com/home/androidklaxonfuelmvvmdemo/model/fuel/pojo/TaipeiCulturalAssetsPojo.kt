package com.home.androidklaxonfuelmvvmdemo.model.fuel.pojo

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.core.ResponseDeserializable

data class TaipeiCulturalAssetsPojo(
    @Json(name = "result")
    val result: Result
) {
    data class Result(
        @Json(name = "limit")
        val limit: Int,
        @Json(name = "offset")
        val offset: Int,
        @Json(name = "count")
        val count: Int,
        @Json(name = "sort")
        val sort: String,
        @Json(name = "results")
        val results: List<Results>
    ) {
        data class Results(
            @Json(name = "pic96_url")
            val pic96Url: String,
            @Json(name = "laws_reference")
            val lawsReference: String,
            @Json(name = "land_scope")
            val landScope: String,
            @Json(name = "building_actual_state")
            val buildingActualState: String,
            @Json(name = "building_brief")
            val buildingBrief: String,
            @Json(name = "longitude")
            val longitude: String,
            @Json(name = "case_name")
            val caseName: String,
            @Json(name = "assets_type_code")
            val assetsTypeCode: String,
            @Json(name = "case_id")
            val caseId: String,
            @Json(name = "official_doc_no")
            val officialDocNo: String,
            @Json(name = "belong_address")
            val belongAddress: String,
            @Json(name = "latitude")
            val latitude: String,
            @Json(name = "belong_city_name")
            val belongCityName: String,
            @Json(name = "_id")
            val id: Int,
            @Json(name = "register_reason")
            val registerReason: String,
            @Json(name = "register_date")
            val registerDate: String,
            @Json(name = "page_url")
            val pageUrl: String
        )
    }

    // 使用Klaxon進行結果解析
    class Deserializer : ResponseDeserializable<TaipeiCulturalAssetsPojo> {
        override fun deserialize(content: String) =
            Klaxon().parse<TaipeiCulturalAssetsPojo>(content)
    }
}