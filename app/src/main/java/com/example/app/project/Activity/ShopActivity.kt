package com.example.app.project.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.app.project.Fragment.ProductFragment
import com.example.app.project.R
import com.example.app.project.Utils.AddToCart
import com.example.app.project.Utils.Constant
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.layout_toolbar_home.*
import kotlinx.android.synthetic.main.nav_menu.*

class ShopActivity : AppCompatActivity(), View.OnClickListener, AddToCart {
    private var navigationView: NavigationView? = null
    private val toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        listeners()

        drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer!!.setDrawerListener(toggle)
        toggle.syncState()

        // we have single fragment "Product Fragment" in this activity
        val fragment: Fragment = ProductFragment(this)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()
    }

    private fun listeners() {
        ivMenu!!.setOnClickListener(this)
        li_item1!!.setOnClickListener(this)
        ivCart!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v == ivMenu) {
            if (drawer!!.isDrawerOpen(GravityCompat.START)) {
                drawer!!.closeDrawer(GravityCompat.START)
            } else {
                drawer!!.openDrawer(GravityCompat.START)
            }
        }
        if (v == li_item1) {
            drawer!!.closeDrawer(GravityCompat.START)

            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }
        if (v == ivCart) {
            Constant.interfaceContext = this as AddToCart

            val intent = Intent(this, CartActivity::class.java)
//            intent.putExtra("interface", this);
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)
        } else {
            if (supportFragmentManager.backStackEntryCount > 1) {
                supportFragmentManager.popBackStack()
            } else {

            }
        }
    }

    companion object {
        var drawer: DrawerLayout? = null
    }

    override fun addCart(position: Int) {

        Constant.cartPositionList.add(position)
        tvCount.text = Constant.cartPositionList.size.toString()

        Log.e("list add", "* "+ Constant.cartPositionList)
    }

    override fun removeCart() {
//        Constant.cartPositionList.remove(Constant.cartPositionList.indexOf(position))
        tvCount.text = Constant.cartPositionList.size.toString()

        Log.e("list remove", "* "+ Constant.cartPositionList)
    }
}