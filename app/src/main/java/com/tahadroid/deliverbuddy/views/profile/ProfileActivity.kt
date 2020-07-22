package com.tahadroid.deliverbuddy.views.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.views.MenuActivity
import com.tahadroid.deliverbuddy.views.order.OrderActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        saveView.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, OrderActivity::class.java))
        }

    }
}