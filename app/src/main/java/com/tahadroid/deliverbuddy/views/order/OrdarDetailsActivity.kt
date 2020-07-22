package com.tahadroid.deliverbuddy.views.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.views.discover.DiscoverActivity
import com.tahadroid.deliverbuddy.views.wallet.WalletActivity
import kotlinx.android.synthetic.main.activity_ordar_details.*

class OrdarDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordar_details)
        view19.setOnClickListener {
            startActivity(Intent(this@OrdarDetailsActivity, WalletActivity::class.java))

        }
    }
}