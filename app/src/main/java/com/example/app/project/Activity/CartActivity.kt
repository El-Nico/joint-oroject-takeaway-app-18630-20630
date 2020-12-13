package com.example.app.project.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app.project.Fragment.CartFragment
import com.example.app.project.R
import com.example.app.project.Utils.AddToCart
import com.example.app.project.Utils.Constant
import kotlinx.android.synthetic.main.activity_about_us.*


class CartActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

//        val intent = intent
//        val inter: AddToCart = intent.getSerializableExtra("interface") as AddToCart

        // listners
        listeners()

        val fragment: Fragment = CartFragment(Constant.interfaceContext!!)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container1, fragment)
        ft.commit()
    }

    private fun listeners() {
        ivBack!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view == ivBack) {
            finish()
        }
    }
}