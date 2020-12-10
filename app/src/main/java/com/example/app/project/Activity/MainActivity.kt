package com.example.app.project.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.app.project.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // listners
        listeners()
    }

    private fun listeners() {
        btn_shop!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view == btn_shop) {
            val intent = Intent(this@MainActivity, ShopActivity::class.java)
            startActivity(intent)
        }
    }
}