package com.home.androidklaxonfuelmvvmdemo.common

import android.app.Application
import androidx.room.Room
import com.home.androidklaxonfuelmvvmdemo.model.fuel.api.Api
import com.home.androidklaxonfuelmvvmdemo.model.repository.MainRepository
import com.home.androidklaxonfuelmvvmdemo.model.room.dao.TaipeiCulturalAssetsDao
import com.home.androidklaxonfuelmvvmdemo.model.room.database.LocalRoomDatabase
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class AKFMDApplication : Application(), KodeinAware {

    /**
     * 實例化Application級的kodein並綁定依賴
     */
    override val kodein = Kodein.lazy {
        // 獲取AppDatabase實例
        val database: LocalRoomDatabase =
            Room.databaseBuilder(
                applicationContext, LocalRoomDatabase::class.java, "local_room_database.db"
            )
                .allowMainThreadQueries() // 允許Room在主線程中訪問數據庫
                .build()
        bind<TaipeiCulturalAssetsDao>() with singleton { database.taipeiCulturalAssetsDao() }
        bind<MainRepository>() with singleton { MainRepository(applicationContext) }
        bind<Api>() with singleton { Api() }
    }

    override fun onCreate() {
        super.onCreate()
        initializeLogger()
    }

    private fun initializeLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false) // (可選)是否顯示線程信息, 默認值為true
            .methodCount(1) // (可選)要顯示的方法行數, 默認值2
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}