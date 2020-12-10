package com.example.app.project.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.app.project.Activity.CheckoutActivity
import com.example.app.project.R
import kotlinx.android.synthetic.main.fragment_display.*

class DisplayFragment : Fragment(), View.OnClickListener {
    private var v: View? = null
    private var image = 0
    private var name: String? = null
    private var desc: String? = null
    private var price: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_display, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v = view

        // receiving data from bundle
        if (arguments != null) {
            image = arguments!!.getInt("image")
            name = arguments!!.getString("name")
            desc = arguments!!.getString("desc")
            price = arguments!!.getString("price")
        }

        // listners
        listeners()

        // setting data in views
        setData()
    }

    private fun listeners() {
        btn_checkout!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view == btn_checkout) {
            val intent = Intent(activity, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setData() {
        tv_name!!.text = name
        tv_description!!.text = desc
        tv_price!!.text = price
        Glide.with(activity!!)
                .load(image)
                .into(img!!)
    }
}