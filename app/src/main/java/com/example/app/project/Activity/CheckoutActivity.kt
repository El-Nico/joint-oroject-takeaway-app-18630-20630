package com.example.app.project.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.project.R
import com.example.app.project.Utils.Constant
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // setting total amount
        tv_price.text = Constant.totalPrice

        // listners
        listeners()
    }

    private fun listeners() {
        btn_checkout!!.setOnClickListener(this)
//        ivBack!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view == btn_checkout) {
            Toast.makeText(this, "Thank you for purchase", Toast.LENGTH_SHORT).show()

            Constant.cartPositionList.clear()
            Constant.product.clear()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }

//        if (view == ivBack) {
//            finish()
//        }
    }
}