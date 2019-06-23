package com.example.webapirxsample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webapirxsample.R
import com.example.webapirxsample.model.Item

class ListAdapter(private val list: List<Item>)
    : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

}

class ItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {

    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null

    private var imageView: ImageView? = null

    init {
        mTitleView = itemView.findViewById(R.id.list_title)
        mYearView = itemView.findViewById(R.id.list_description)
        imageView = itemView.findViewById(R.id.itemImageView)
    }

    fun bind(item: Item) {
        mTitleView?.text = item.title
        mYearView?.text = item.service_name

        Glide.with(itemView.context).load(item.imageURL.small).into(imageView)
    }
}