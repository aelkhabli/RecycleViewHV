package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.api.Item

class ItemAdapter(private val context: Context, private val itemList: ArrayList<Item>) :
    RecyclerView.Adapter<ItemAdapter.CustomViewHolder>() {
    private val inflater: LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View
        view = inflater.inflate(R.layout.item_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val chapter = itemList[position]
        holder.itemName.text = chapter.itemApi
        holder.itemImage.setImageResource(chapter.idImage)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView
        var itemImage: ImageView


        init {
            itemName = itemView.findViewById<View>(R.id.itemName) as TextView
            itemImage = itemView.findViewById<View>(R.id.itemImage) as ImageView
        }
    }

    init {
        inflater = LayoutInflater.from(context)
    }
}