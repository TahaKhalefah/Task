package com.tahadroid.deliverbuddy.models

import com.tahadroid.deliverbuddy.R

data class Order(
    val mOrderImage: Int = R.drawable.foodicon,
    val mOrderName: String = "Ayam Geprek",
    val mOrderDesc: String = "feb 23 th,at 6:30,feb 23 th,at 6:30",
    val mOrderCost: String = "IDR 46.000"
)