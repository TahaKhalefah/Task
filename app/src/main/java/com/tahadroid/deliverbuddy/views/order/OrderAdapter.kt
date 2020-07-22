package com.tahadroid.deliverbuddy.views.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.models.Order
import kotlinx.android.synthetic.main.layout_order_item.view.*


class OrderAdapter(val listener: (View, Order, Int) -> Unit) :
    RecyclerView.Adapter<OrderAdapter.ProductViewHolder>() {
    private var data: List<Order> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_order_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(data: List<Order>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Order) = with(itemView) {
            orderName_tv.text = item.mOrderName
            orderDesc_tv.text = item.mOrderDesc
            orderImage_iv.setImageResource(item.mOrderImage)
            orderCost_tv.text = item.mOrderCost
            setOnClickListener {
                listener.invoke(it, item, adapterPosition)
            }
        }
    }
}