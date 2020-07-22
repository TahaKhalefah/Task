package com.tahadroid.deliverbuddy.views.order

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.models.Order
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {
    lateinit var orderAdapter: OrderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        orderAdapter = OrderAdapter { view, myTab, i ->
            startActivity(Intent(this@OrderActivity, OrdarDetailsActivity::class.java))
        }

        val list = ArrayList<Order>()
        for (i in 0..10) {
            val tab = Order()
            list.add(tab)
        }

        orderAdapter.swapData(list)

        order_rv.apply {
            adapter = orderAdapter
        }


    }

}