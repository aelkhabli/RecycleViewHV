package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.ItemCategoryAdapter
import com.example.myapplication.api.ItemsCategory
import com.example.myapplication.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var itemCategoryAdapter: ItemCategoryAdapter
    lateinit var viewModel: MainActivityViewModel
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    private var itemCategory = ArrayList<ItemsCategory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewComponent()
    }

    fun initViewComponent() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        recyclerView = findViewById<View>(R.id.rvSubject) as RecyclerView
        itemCategory = viewModel.prepareData()
        itemCategoryAdapter = ItemCategoryAdapter(this, itemCategory)
        recyclerView.layoutManager = LinearLayoutManager(this)
        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = itemCategoryAdapter
    }

}
