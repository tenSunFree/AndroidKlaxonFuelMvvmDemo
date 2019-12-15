package com.home.androidklaxonfuelmvvmdemo.common.base

import android.content.Context
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein

abstract class BaseRepository<out T>(context: Context) : KodeinAware {

    override val kodein: Kodein by closestKodein(context)
    override val kodeinTrigger: KodeinTrigger = KodeinTrigger()

    @Suppress("UNCHECKED_CAST")
    fun init(): T {
        kodeinTrigger.trigger() // 手動觸發加載依賴(取消懶加載) 避免依賴死循環
        return this as T
    }
}