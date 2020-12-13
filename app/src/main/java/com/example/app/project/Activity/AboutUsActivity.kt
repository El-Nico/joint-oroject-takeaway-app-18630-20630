package com.example.app.project.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app.project.R
import kotlinx.android.synthetic.main.activity_about_us.*

class AboutUsActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        // listners
        listeners()
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