package com.home.androidklaxonfuelmvvmdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.home.androidklaxonfuelmvvmdemo.common.base.BaseViewModel
import com.home.androidklaxonfuelmvvmdemo.model.repository.MainRepository
import com.home.androidklaxonfuelmvvmdemo.model.room.entity.TaipeiCulturalAssetsEntity
import org.kodein.di.generic.instance

class MainHomeViewModel : BaseViewModel<MainHomeViewModel>() {

    private val mainRepository by instance<MainRepository>()
    private var taipeiCulturalAssetsList: LiveData<PagedList<TaipeiCulturalAssetsEntity>> =
        MutableLiveData()

    fun isLoading(): LiveData<Boolean> {
        return mainRepository.isLoading
    }

    fun getTaipeiCulturalAssetsList(max: Int): LiveData<PagedList<TaipeiCulturalAssetsEntity>> {
        taipeiCulturalAssetsList = mainRepository.getTaipeiCulturalAssetsList(max)
        return taipeiCulturalAssetsList
    }

    fun fetchTaipeiCulturalAssetsList() = mainRepository.fetchTaipeiCulturalAssetsList()
}