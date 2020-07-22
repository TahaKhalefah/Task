package com.tahadroid.deliverbuddy.views.wallet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.views.MenuActivity
import com.tahadroid.deliverbuddy.views.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_wallet.*

class WalletActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        view21.setOnClickListener {
            startActivity(Intent(this@WalletActivity, MenuActivity::class.java))
        }
    }
}