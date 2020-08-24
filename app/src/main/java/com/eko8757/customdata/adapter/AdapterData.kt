package com.eko8757.customdata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eko8757.customdata.R
import com.eko8757.customdata.model.data.ResultData
import com.eko8757.customdata.utils.Constants
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterData(val items: ArrayList<ResultData>) : RecyclerView.Adapter<AdapterData.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    fun setOnItemClickListener(itemClick: OnItemClickListener) {
        this.itemClickListener = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position], itemClickListener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(data: ResultData, itemClickListener: OnItemClickListener) {
            itemView.tv_title_list.text = data.title
            Glide.with(itemView.context).load(Constants.IMAGE_PATH + data.backdropPath).into(itemView.img_list)

            itemView.setOnClickListener {
                val position: Int = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener.onItemClick(position)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}