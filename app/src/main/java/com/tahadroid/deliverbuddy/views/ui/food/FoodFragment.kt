package com.tahadroid.deliverbuddy.views.ui.food

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.models.Food
import com.tahadroid.deliverbuddy.models.MyTab
import kotlinx.android.synthetic.main.fragment_food.*


class FoodFragment : Fragment(R.layout.fragment_food) {

    lateinit var foodTabAdapter: FoodTabAdapter
    lateinit var foodAdapter: FoodAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView() {

        foodAdapter = FoodAdapter { view, product, i ->
        }
        val list2 = ArrayList<Food>()

        val product = Food(R.drawable.one, "Pizza")
        val product2 = Food(R.drawable.two, "Sushi")
        val product3 = Food(R.drawable.three, "Burgers")
        val product11 = Food(R.drawable.one, "Pizza")
        val product22 = Food(R.drawable.two, "Sushi")
        val product33 = Food(R.drawable.three, "Burgers")
        val product111 = Food(R.drawable.one, "Pizza")
        val product222 = Food(R.drawable.two, "Sushi")
        val product333 = Food(R.drawable.three, "Burgers")
        list2.add(product)
        list2.add(product2)
        list2.add(product3)
        list2.add(product11)
        list2.add(product22)
        list2.add(product33)
        list2.add(product111)
        list2.add(product222)
        list2.add(product333)

        foodAdapter.swapData(list2)
        food_stage_rv.adapter = foodAdapter

        foodTabAdapter = FoodTabAdapter { view, myTab, i ->
        }
        val list = ArrayList<MyTab>()
        for (i in 0..10) {
            val tab = MyTab()
            list.add(tab)
        }

        foodTabAdapter.swapData(list)

        food_rv.apply {
            adapter = foodTabAdapter
        }


    }
}