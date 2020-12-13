package com.example.app.project.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.app.project.Database.AppDataBase
import com.example.app.project.Database.AppDataBase.Companion.getAppDatabase
import com.example.app.project.Entity.FoodItemTable
import com.example.app.project.Model.ModelProduct

class FoodItemsViewModel(application: Application) : AndroidViewModel(application) {
    var database: AppDataBase?
    fun createDatabaseWithData(modelProduct: ModelProduct) {

        //Add dish in table
        val dishItemTable = FoodItemTable()
        dishItemTable.foodName = modelProduct.name
        dishItemTable.price = modelProduct.price
        dishItemTable.image = modelProduct.images
        database!!.cartDao()!!.insertFoodItem(dishItemTable)
    }

    val allFoodItems: Array<FoodItemTable>
        get() = database!!.cartDao()!!.allFoodItems

    fun clearDatabase() {
        database!!.cartDao()!!.deleteFoodItemTable()
    }

    companion object {
        private val TAG = FoodItemsViewModel::class.java.simpleName
    }

    init {
        database = getAppDatabase(getApplication<Application>().baseContext)
    }
}