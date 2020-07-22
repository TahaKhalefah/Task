package com.tahadroid.deliverbuddy.views.gps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.views.home.HomeActivity
import com.tahadroid.deliverbuddy.views.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_gps.*

class GpsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)
        logo_image.setOnClickListener {
            startActivity(Intent(this@GpsActivity, ProfileActivity::class.java))

        }
    }
}