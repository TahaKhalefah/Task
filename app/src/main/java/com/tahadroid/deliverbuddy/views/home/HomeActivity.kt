package com.tahadroid.deliverbuddy.views.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.views.product.ProductsActivity
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupActionBar()
        content.startRippleAnimation();
        include1.setOnClickListener {
            startActivity(Intent(this@HomeActivity, ProductsActivity::class.java))

        }
        logo_image.setOnClickListener {
            content.stopRippleAnimation()
            resizeLogoImage()
            include1.visibility = View.VISIBLE
            include2.visibility = View.VISIBLE
            include3.visibility = View.VISIBLE
            include4.visibility = View.VISIBLE
            include5.visibility = View.VISIBLE
            include6.visibility = View.VISIBLE
        }
    }

    private fun resizeLogoImage() {
        val params = logo_image.layoutParams
        params.width = 300
        params.height = 300
        logo_image.layoutParams = params
    }

    private fun setupActionBar() {
        setSupportActionBar(customToolbar)
        title = ""
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}