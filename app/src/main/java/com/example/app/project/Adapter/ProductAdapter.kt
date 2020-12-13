package com.example.app.project.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.project.Fragment.ProductFragment
import com.example.app.project.Model.ModelProduct
import com.example.app.project.R
import com.example.app.project.Utils.AddToCart
import com.example.app.project.Utils.Constant
import java.util.*

class ProductAdapter(cntx: Context, product: ArrayList<ModelProduct>,val inter: AddToCart) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
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
        // setting product price
        holder.tv_price.text = "$ " + product[position].price

        if (Constant.cartPositionList.size > 0) {
            if (Constant.cartPositionList.contains(position)) {
                holder.btn_addToCart.visibility = View.GONE
            } else {
                holder.btn_addToCart.visibility = View.VISIBLE
            }
        }else{
            holder.btn_addToCart.visibility = View.VISIBLE
        }

            // when user click a product in recyclerview, data of that will send to display activity using this code.
        holder.btn_addToCart.setOnClickListener {

            holder.btn_addToCart.visibility = View.GONE
            inter.addCart(position)

        }
    }

    // total number of rows
    override fun getItemCount(): Int {
        return product.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var tv_name: TextView
        var tv_price: TextView
        var btn_addToCart: Button

        init {
            image = itemView.findViewById(R.id.image)
            tv_name = itemView.findViewById(R.id.tv_name)
            tv_price = itemView.findViewById(R.id.tv_price)
            btn_addToCart = itemView.findViewById(R.id.btn_addToCart)
        }
    }

}