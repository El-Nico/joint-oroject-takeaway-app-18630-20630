package com.example.app.project.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.app.project.Entity.FoodItemTable
import com.example.app.project.Model.ModelProduct
import com.example.app.project.R
import com.example.app.project.ViewModel.FoodItemsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var foodItemsViewModel: FoodItemsViewModel? = null

    // images
    private val Images = intArrayOf(R.drawable.baked_apple_pie, R.drawable.double_cheeseburger, R.drawable.egg_mcmuffin,
            R.drawable.french_fries, R.drawable.mcgriddles, R.drawable.premium_salads, R.drawable.snack_wrap)

    // item name
    private val Name = arrayOf("Baked Apple Pie", "Double Cheeseburger", "Egg McMuffin", "French Fries", "McGriddles Sandwich", "Premium Salads", "Snack Wrap")

    // item price
    private val price = arrayOf("1", "3", "2", "5", "10", "7", "8")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        foodItemsViewModel = ViewModelProviders.of(this).get<FoodItemsViewModel>(FoodItemsViewModel::class.java)

        val foodItemTables: Array<FoodItemTable> = foodItemsViewModel!!.allFoodItems

        if (foodItemTables.size > 0) {
            foodItemsViewModel!!.clearDatabase()
        }

        // getting data from array's defined above and setting it to arraylist and
        // then put arraylist to recycler adapter.
        for (i in Images.indices) {
            val model = ModelProduct()
            model.images = Images[i]
            model.name = Name[i]
            model.price = price[i]

            foodItemsViewModel!!.createDatabaseWithData(model)
        }

        // listners
        listeners()
    }

    private fun listeners() {
        btn_shop!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view == btn_shop) {
            val intent = Intent(this@MainActivity, ShopActivity::class.java)
            startActivity(intent)
        }
    }
}