package com.home.androidklaxonfuelmvvmdemo.view.activity

import android.os.Bundle
import com.home.androidklaxonfuelmvvmdemo.R
import com.home.androidklaxonfuelmvvmdemo.common.base.BaseActivity
import com.home.androidklaxonfuelmvvmdemo.view.fragment.MainHomeFragment
import com.orhanobut.logger.Logger

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Logger.d("MainActivity, onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showMainFragment()
    }

    private fun showMainFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.constraint_layout_container, MainHomeFragment())
            .commit()
    }
}