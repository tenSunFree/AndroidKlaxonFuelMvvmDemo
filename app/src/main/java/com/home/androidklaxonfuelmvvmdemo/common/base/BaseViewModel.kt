package com.home.androidklaxonfuelmvvmdemo.common.base

import androidx.lifecycle.ViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger

abstract class BaseViewModel<out T> : ViewModel(), KodeinAware {

    override lateinit var kodein: Kodein
    override val kodeinTrigger: KodeinTrigger = KodeinTrigger()

    @Suppress("UNCHECKED_CAST")
    fun init(kodein: Kodein): T {
        this.kodein = kodein
        kodeinTrigger.trigger() // 手動觸發加載依賴(取消懶加載) 避免依賴死循環
        return this as T
    }
}