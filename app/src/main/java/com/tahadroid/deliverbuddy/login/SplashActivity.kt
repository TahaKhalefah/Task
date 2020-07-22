package com.tahadroid.deliverbuddy.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tahadroid.deliverbuddy.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val mIntent = Intent(this@SplashActivity, RegisterActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 2000)
    }


}