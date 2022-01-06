package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.api.Item
import com.example.myapplication.api.ItemsCategory

class MainActivityViewModel: ViewModel() {
    lateinit var mSubjects: MutableLiveData<ItemsCategory>

    init {
        mSubjects = MutableLiveData()
    }

    fun getItemListObervable(): MutableLiveData<ItemsCategory> {
        return mSubjects
    }

    fun prepareData(): ArrayList<ItemsCategory> {
        //Dans le test il ya deux recycle view demandé
        val itemCategoryList = ArrayList<ItemsCategory>()
        val itemCategory1 = ItemsCategory()
        val itemCategory2 = ItemsCategory()

        itemCategory1.id = 1
        itemCategory1.itemTypeName = "RecycleView1"
        itemCategory1.mItem = ArrayList()

        val item1 = Item()
        item1.itemApiId = 1
        item1.itemApi = "itemApi1"
        item1.idImage = R.drawable.img

        val item2 = Item()
        item2.itemApiId = 2
        item2.itemApi = "itemApi2"
        item2.idImage = R.drawable.ic_launcher_foreground

        val item3 = Item()
        item3.itemApiId = 3
        item3.itemApi = "itemApi3"
        item3.idImage = R.drawable.ic_launcher_foreground

        val item4 = Item()
        item4.itemApiId = 4
        item4.itemApi = "itemApi4"
        item4.idImage = R.drawable.ic_launcher_foreground

        val item5 = Item()
        item5.itemApiId = 5
        item5.itemApi = "itemApi5"
        item5.idImage = R.drawable.ic_launcher_foreground

        val item6 = Item()
        item6.itemApiId = 6
        item6.itemApi = "itemApi6"
        item6.idImage = R.drawable.ic_launcher_foreground

        itemCategory1.mItem!!.add(item1)
        itemCategory1.mItem!!.add(item2)
        itemCategory1.mItem!!.add(item3)
        itemCategory1.mItem!!.add(item4)
        itemCategory1.mItem!!.add(item5)


        itemCategory2.id = 2
        itemCategory2.itemTypeName = "RecycleView2"
        itemCategory2.mItem = ArrayList()

        itemCategory2.mItem!!.add(item1)
        itemCategory2.mItem!!.add(item2)
        itemCategory2.mItem!!.add(item3)
        itemCategory2.mItem!!.add(item4)
        itemCategory2.mItem!!.add(item5)

        itemCategoryList.add(itemCategory1)
        itemCategoryList.add(itemCategory2)

        //Vous  pouvez ajoutez plusieurs itemsCategory pour verifiez le fonctionnement  de scroll verticale
        //le test demande 2 item itemCategory
        return itemCategoryList
    }
}