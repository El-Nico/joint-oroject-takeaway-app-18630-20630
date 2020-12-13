package com.example.app.project.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.app.project.Adapter.ProductAdapter
import com.example.app.project.Entity.FoodItemTable
import com.example.app.project.Model.ModelProduct
import com.example.app.project.R
import com.example.app.project.Utils.AddToCart
import com.example.app.project.Utils.Constant
import com.example.app.project.ViewModel.FoodItemsViewModel
import kotlinx.android.synthetic.main.fragment_product.*

class ProductFragment(val inter: AddToCart) : Fragment() {
    private var v: View? = null
    private var adapter: ProductAdapter? = null
    var foodItemsViewModel: FoodItemsViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_product, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v = view
        foodItemsViewModel = ViewModelProviders.of(this).get<FoodItemsViewModel>(FoodItemsViewModel::class.java)
        val foodItems: Array<FoodItemTable> = foodItemsViewModel!!.allFoodItems

        for (i in foodItems.indices) {
            val model = ModelProduct()
            model.images = foodItems[i].image
            model.name = foodItems[i].foodName
            model.price = foodItems[i].price

            Constant.product.add(model)
        }

        recyclerview!!.setHasFixedSize(true)

//        adapter = ProductAdapter(activity!!, Constant.product!!, inter)
//        recyclerview!!.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        adapter = ProductAdapter(activity!!, Constant.product!!, inter)
        recyclerview!!.adapter = adapter
    }
}