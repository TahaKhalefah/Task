package com.tahadroid.deliverbuddy.views.product

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.models.MyTab
import com.tahadroid.deliverbuddy.models.Product
import com.tahadroid.deliverbuddy.views.discover.DiscoverActivity
import com.tahadroid.deliverbuddy.views.wallet.WalletActivity
import kotlinx.android.synthetic.main.activity_home.customToolbar
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {
    lateinit var productTabAdapter: ProductTabAdapter
    lateinit var productAdapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        setSupportActionBar(customToolbar)
        title = ""
        setRecyclerView()

    }

    private fun setRecyclerView() {
        productTabAdapter = ProductTabAdapter { _, _, _ ->
            startActivity(Intent(this@ProductsActivity, DiscoverActivity::class.java))
        }
        productAdapter = ProductAdapter { _, _, _ ->
        }
        val list = ArrayList<MyTab>()
        for (i in 0..10) {
            val tab = MyTab()
            list.add(tab)
        }
        val list2 = ArrayList<Product>()
        for (i in 0..10) {
            val product = Product()
            list2.add(product)
        }
        productTabAdapter.swapData(list)
        productAdapter.swapData(list2)
        tab_rv.apply {
            adapter = productTabAdapter
        }
        stag_rv.adapter = productAdapter

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}