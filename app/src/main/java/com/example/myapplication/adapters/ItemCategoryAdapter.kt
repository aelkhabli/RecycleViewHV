package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.api.ItemsCategory

class ItemCategoryAdapter(private val context: Context, var itemCategoryList: ArrayList<ItemsCategory>) :
    RecyclerView.Adapter<ItemCategoryAdapter.ViewHolder>() {
    private val layoutInflater: LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recyclerView.adapter = itemCategoryList[position].mItem?.let {
            ItemAdapter(
                context,
                it
            )
        }
        holder.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.setHasFixedSize(true)
        holder.itemCategoryTitle.text = itemCategoryList[position].itemTypeName
    }

    override fun getItemCount(): Int {
        return itemCategoryList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView
        var itemCategoryTitle: TextView

        init {
            recyclerView = itemView.findViewById<View>(R.id.recyclerViewItem) as RecyclerView
            itemCategoryTitle = itemView.findViewById<View>(R.id.itemCategoryName) as TextView
        }
    }

    init {
        layoutInflater = LayoutInflater.from(context)
    }
}