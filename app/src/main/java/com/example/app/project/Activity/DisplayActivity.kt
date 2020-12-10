package com.example.app.project.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app.project.Fragment.DisplayFragment
import com.example.app.project.R

class DisplayActivity : AppCompatActivity() {
    private var image = 0
    private var name: String? = null
    private var desc: String? = null
    private var price: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // receiving data through intent
        val extras = intent.extras
        if (extras != null) {
            image = extras.getInt("image")
            name = extras.getString("name")
            desc = extras.getString("desc")
            price = extras.getString("price")
        }

        // sending data to the display fragment with bundle
        val fragment: Fragment = DisplayFragment()
        val bundle = Bundle()
        bundle.putInt("image", image)
        bundle.putString("name", name)
        bundle.putString("desc", desc)
        bundle.putString("price", price)

        fragment.arguments = bundle
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container1, fragment)
        ft.commit()
    }
}