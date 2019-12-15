package com.home.androidklaxonfuelmvvmdemo.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.home.androidklaxonfuelmvvmdemo.R
import com.home.androidklaxonfuelmvvmdemo.model.room.entity.TaipeiCulturalAssetsEntity
import kotlinx.android.synthetic.main.fragment_main_home_recycler_view_item.view.*

class MainHomeAdapter : androidx.recyclerview.widget.ListAdapter<
        TaipeiCulturalAssetsEntity, MainHomeAdapter.ViewHolder>(ItemCallback()) {

    private class ItemCallback : DiffUtil.ItemCallback<TaipeiCulturalAssetsEntity>() {

        override fun areItemsTheSame(
            oldItem: TaipeiCulturalAssetsEntity, newItem: TaipeiCulturalAssetsEntity
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: TaipeiCulturalAssetsEntity, newItem: TaipeiCulturalAssetsEntity
        ): Boolean = oldItem.caseName == newItem.caseName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_main_home_recycler_view_item, parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = getItem(position)
        if (entity != null)
            holder.bind(entity)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(entity: TaipeiCulturalAssetsEntity?) = with(itemView) {
            text_view_case_name.text = "名稱︰" + entity?.caseName
            text_view_register_date.text = "登錄公告日期︰" + entity?.registerDate
        }
    }
}