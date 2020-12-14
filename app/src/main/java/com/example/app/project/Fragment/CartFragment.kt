package com.example.app.project.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app.project.Activity.CheckoutActivity
import com.example.app.project.Adapter.CartAdapter
import com.example.app.project.Model.ModelProduct
import com.example.app.project.R
import com.example.app.project.Utils.AddToCart
import com.example.app.project.Utils.Constant
import com.example.app.project.Utils.UpdateTotalAmount
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_cart.recyclerview

class CartFragment(val inter: AddToCart) : Fragment(), View.OnClickListener, UpdateTotalAmount {
    private var v: View? = null
    private var adapter: CartAdapter? = null
    private var total: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_cart, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v = view

            for (i in Constant.cartPositionList.indices) {
                total = total + (Constant.product[Constant.cartPositionList[i]].price)!!.toInt()
            }

        // setting total amount
        tv_total.text = "Total Amount : € " + total.toString()
        Constant.totalPrice = "€ " + total.toString()

        // listners
        listeners()

        recyclerview!!.setHasFixedSize(true)
        adapter = CartAdapter(activity!!, inter, this)
        recyclerview!!.adapter = adapter

    }

    private fun listeners() {
        btn_pay!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view == btn_pay) {
            val intent = Intent(activity, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }

    override fun update() {
        total = 0

        for (i in Constant.cartPositionList.indices) {
            total = total + (Constant.product[Constant.cartPositionList[i]].price)!!.toInt()
        }

        // setting total amount
        tv_total.text = "Total Amount : € " + total.toString()
        Constant.totalPrice = "€ " + total.toString()
    }

}