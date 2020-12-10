package com.example.app.project.Fragment

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.project.Adapter.ProductAdapter
import com.example.app.project.Model.ModelProduct
import com.example.app.project.R
import kotlinx.android.synthetic.main.fragment_product.*
import java.util.*

class ProductFragment : Fragment() {
    private var v: View? = null
    private var adapter: ProductAdapter? = null
    private var product: ArrayList<ModelProduct>? = null

    // images
    private val Images = intArrayOf(R.drawable.baked_apple_pie, R.drawable.double_cheeseburger, R.drawable.egg_mcmuffin,
            R.drawable.french_fries, R.drawable.mcgriddles, R.drawable.premium_salads, R.drawable.snack_wrap)

    // item name
    private val Name = arrayOf("Baked Apple Pie", "Double Cheeseburger", "Egg McMuffin", "French Fries", "McGriddles Sandwich", "Premium Salads", "Snack Wrap")

    // item description
    private val Description = arrayOf("Baked Apple Pie is made with a tender, flaky lattice-top crust with a sprinkled sugar topping and 100% American-grown apples.",
            "The Double Cheeseburger features two 100% pure beef patties seasoned with just a pinch of salt and pepper. It's topped with tangy pickles, chopped onions, ketchup, mustard and two slices of melty American cheese.",
            "The Egg McMuffin is basically a breakfast sandwich including an English muffin, fried egg, cheese, and ham (AKA Canadian style bacon).",
            "The fries are dipped in various ingredients, fried and frozen. McDonald's uses a variety of potatoes, including Ranger Russet, Umatilla Russet, Russet Burbank and Shepody.",
            " The standard McGriddles sandwich consists of fried bacon, a scrambled egg flap, and American cheese served on a small pancake made with maple flavoring.",
            "Grilled chicken made with all white meat chicken filet with no artificial preservatives, flavors or colors – grilled and seasoned to perfection with ingredients like salt, garlic powder and parsley.",
            "The Snack Wrap consists of 100% white meat chicken breast (crispy or grilled), lettuce, shredded cheddar jack cheese, Monterey Jack cheese, and sauce (ranch, honey mustard or salsa roja), wrapped in a soft flour tortilla.")

    // item price
    private val price = arrayOf("$ 0.99", "$ 1.69", "$ 4.19", "$ 1.79", "$ 3.29", "$ 4.79", "$ 1.69")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_product, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v = view

        product = ArrayList()
        recyclerview!!.setHasFixedSize(true)

        // LinearLayoutManager is used to set the orientation and some other features in recyclerview.
        val manager1 = LinearLayoutManager(activity)
        manager1.orientation = RecyclerView.VERTICAL
        recyclerview!!.layoutManager = manager1

        // getting data from array's defined above and setting it to arraylist and
        // then put arraylist to recycler adapter.
        for (i in Images.indices) {
            val model = ModelProduct()
            model.images = Images[i]
            model.name = Name[i]
            model.description = Description[i]
            model.price = price[i]
            product!!.add(model)
        }
        adapter = ProductAdapter(activity!!, product!!)
        recyclerview!!.adapter = adapter
    }
}