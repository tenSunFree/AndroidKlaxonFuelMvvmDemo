package com.home.androidklaxonfuelmvvmdemo.model.fuel.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.RequestFactory
import com.github.kittinunf.fuel.livedata.liveDataObject
import com.home.androidklaxonfuelmvvmdemo.model.fuel.pojo.TaipeiCulturalAssetsPojo
import com.home.androidklaxonfuelmvvmdemo.model.fuel.routing.MainFuelRouting

class Api {

    private fun request(api: RequestFactory.RequestConvertible): Request {
        val timeout = 30000
        return Fuel.request(api).timeout(timeout)
    }

    fun getTaipeiCulturalAssetsPojo() =
        request(MainFuelRouting.TaipeiCulturalAssetsPojo())
            .liveDataObject(TaipeiCulturalAssetsPojo.Deserializer())
}