package com.tahadroid.deliverbuddy.views.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.models.MyTab
import kotlinx.android.synthetic.main.layout_tab_item.view.*

class ProductTabAdapter(val listener: (View, MyTab, Int) -> Unit) :
    RecyclerView.Adapter<ProductTabAdapter.ProductTabViewHolder>() {
    private var data: List<MyTab> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductTabViewHolder {
        return ProductTabViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_tab_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ProductTabViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(data: List<MyTab>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ProductTabViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MyTab) = with(itemView) {
            tab_iv.setImageResource(item.mImge)
            title_tv.text = item.mTitle
            setOnClickListener {
                listener.invoke(it, item, adapterPosition)
            }
        }
    }
}