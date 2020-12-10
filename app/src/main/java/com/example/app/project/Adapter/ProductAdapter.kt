package com.example.app.project.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.project.Activity.DisplayActivity
import com.example.app.project.Model.ModelProduct
import com.example.app.project.R
import java.util.*

class ProductAdapter(cntx: Context, product: ArrayList<ModelProduct>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private val context: Context
    private val product: ArrayList<ModelProduct>
    private val mInflater: LayoutInflater

    init {
        // getting data and setting it here in adapter
        mInflater = LayoutInflater.from(cntx)
        this.product = product
        context = cntx
    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
            // setting product image
            Glide.with(context)
                    .load(product[position].images)
                    .into(holder.image)

            // setting product name
        holder.tv_name.text = product[position].name

            // when user click a product in recyclerview, data of that will send to display activity using this code.
        holder.li.setOnClickListener { // sending data through intent
                val intent = Intent(context, DisplayActivity::class.java)
                intent.putExtra("image", product[position].images)
                intent.putExtra("name", product[position].name)
                intent.putExtra("desc", product[position].description)
                intent.putExtra("price", product[position].price)
                context.startActivity(intent)
            }
    }

    // total number of rows
    override fun getItemCount(): Int {
        return product.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var li: LinearLayout
        var image: ImageView
        var tv_name: TextView

        init {
            li = itemView.findViewById(R.id.li)
            image = itemView.findViewById(R.id.image)
            tv_name = itemView.findViewById(R.id.tv_name)
        }
    }

}