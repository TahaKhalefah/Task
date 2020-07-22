package com.tahadroid.deliverbuddy.views.discover

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.views.gps.GpsActivity
import kotlinx.android.synthetic.main.activity_discover.*

class DiscoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)
        view9.setOnClickListener {
            startActivity(Intent(this@DiscoverActivity, GpsActivity::class.java))

        }
    }
}