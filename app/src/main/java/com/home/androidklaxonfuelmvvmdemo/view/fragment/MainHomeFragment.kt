package com.home.androidklaxonfuelmvvmdemo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.home.androidklaxonfuelmvvmdemo.R
import com.home.androidklaxonfuelmvvmdemo.common.base.BaseFragment
import com.home.androidklaxonfuelmvvmdemo.view.adapter.MainHomeAdapter
import com.home.androidklaxonfuelmvvmdemo.viewmodel.MainHomeViewModel
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_main_home.*

class MainHomeFragment : BaseFragment() {

    private lateinit var model: MainHomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this).get(MainHomeViewModel::class.java).init(kodein)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Logger.d("MainHomeFragment, onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
        model.fetchTaipeiCulturalAssetsList()
    }

    private fun initializeRecyclerView() {
        val adapter = MainHomeAdapter()
        recycler_view.adapter = adapter
        model.getTaipeiCulturalAssetsList(Int.MAX_VALUE).observe(this, Observer { list ->
            Logger.d("MainHomeFragment, initializeRecyclerView, size: " + list.size)
            adapter.submitList(list)
            if (list.size != 0) {
                hideProgressBar()
            }
        })
        model.isLoading().observe(this, Observer {
            if (it) {
                showProgressBar()
            } else {
                hideProgressBar()
            }
        })
    }

    private fun showProgressBar() {
        Logger.d("MainHomeFragment, showProgressBar")
        progress_bar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        Logger.d("MainHomeFragment, hideProgressBar")
        progress_bar.visibility = View.GONE
    }
}