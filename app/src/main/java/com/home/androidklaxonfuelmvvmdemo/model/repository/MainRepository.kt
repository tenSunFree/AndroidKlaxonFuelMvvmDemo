package com.home.androidklaxonfuelmvvmdemo.model.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.home.androidklaxonfuelmvvmdemo.common.base.BaseRepository
import com.home.androidklaxonfuelmvvmdemo.model.fuel.api.Api
import com.home.androidklaxonfuelmvvmdemo.model.room.dao.TaipeiCulturalAssetsDao
import com.home.androidklaxonfuelmvvmdemo.model.room.entity.TaipeiCulturalAssetsEntity
import com.orhanobut.logger.Logger
import org.jetbrains.anko.toast
import org.kodein.di.generic.instance

class MainRepository(private val context: Context) :
    BaseRepository<MainRepository>(context = context) {

    private val initialLoadSizeHint = 10 // 初始化加載的數量
    private val pageSize = 10 // 配置分頁加載的數量
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private val dao by instance<TaipeiCulturalAssetsDao>()
    private val api by instance<Api>()

    private val pagingConfig = PagedList.Config.Builder()
        .setInitialLoadSizeHint(initialLoadSizeHint)
        .setPageSize(pageSize)
        .build()

    /**
     * 用LivePagedListBuilder 生成LiveData<PagedList<Entity>>
     */
    fun getTaipeiCulturalAssetsList(max: Int) =
        LivePagedListBuilder(dao.getTaipeiCulturalAssetsList(max), pagingConfig).build()

    fun fetchTaipeiCulturalAssetsList() {
        isLoading.postValue(true)
        api.getTaipeiCulturalAssetsPojo().observeForever { result ->
            result?.fold(success = {
                Logger.d("MainRepository, success, size: " + it.result.results.size)
                dao.updateTaipeiCulturalAssetsList(
                    TaipeiCulturalAssetsEntity.fromTaipeiCulturalAssetsPojo(it)
                )
                isLoading.postValue(false)
            }, failure = {
                Logger.d("MainRepository, success, exception: " + it.exception)
                isLoading.postValue(false)
                context.toast(it.exception.toString())
            })
        }
    }
}