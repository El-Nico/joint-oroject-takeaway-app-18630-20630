package com.example.app.project.Adapter

import android.content.Context
import android.util.Log
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
import com.example.app.project.Utils.UpdateTotalAmount
import java.util.*

class CartAdapter(cntx: Context, val inter: AddToCart, val update: UpdateTotalAmount) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    private val context: Context
    private val mInflater: LayoutInflater

    init {
        // getting data and setting it here in adapter
        mInflater = LayoutInflater.from(cntx)
        context = cntx
    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartAdapter.ViewHolder, position: Int) {
            // setting product image
            Glide.with(context)
                    .load(Constant.product[Constant.cartPositionList[position]].images)
                    .into(holder.image)

            // setting product name
        holder.tv_name.text = Constant.product[Constant.cartPositionList[position]].name
        // setting product price
        holder.tv_price.text = "€ " + Constant.product[Constant.cartPositionList[position]].price

            // when user click a product in recyclerview, data of that will send to display activity using this code.
        holder.btn_remove.setOnClickListener {
            Log.e("test remove", ""+ Constant.cartPositionList[position])
            Constant.cartPositionList.removeAt(Constant.cartPositionList.indexOf(Constant.cartPositionList[position]))
            Log.e("test after remove", ""+ Constant.cartPositionList)

            inter.removeCart()
            notifyDataSetChanged()
            update.update()
        }
    }

    // total number of rows
    override fun getItemCount(): Int {
        return Constant.cartPositionList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var tv_name: TextView
        var tv_price: TextView
        var btn_remove: Button

        init {
            image = itemView.findViewById(R.id.image)
            tv_name = itemView.findViewById(R.id.tv_name)
            tv_price = itemView.findViewById(R.id.tv_price)
            btn_remove = itemView.findViewById(R.id.btn_remove)
        }
    }

}