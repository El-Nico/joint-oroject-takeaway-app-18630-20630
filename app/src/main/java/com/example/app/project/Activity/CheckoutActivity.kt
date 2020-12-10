package com.example.app.project.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app.project.R
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity(), View.OnClickListener {

    private var str_name: String? = null
    private var str_quantity: String? = null
    private var str_pay: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // listners
        listeners()
    }

    private fun listeners() {
        btn_save!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view == btn_save) {
            str_name = et_name!!.text.toString()
            str_quantity = et_quantity!!.text.toString()

            // checking which checkbox is selected
            if (radio1!!.isChecked) {
                str_pay = radio1!!.text.toString()
            } else if (radio2!!.isChecked) {
                str_pay = radio2!!.text.toString()
            } else if (radio3!!.isChecked) {
                str_pay = radio3!!.text.toString()
            }

            // setting data
            tv_name!!.text = str_name
            tv_quantity!!.text = str_quantity
            tv_pay!!.text = str_pay
        }
    }
}