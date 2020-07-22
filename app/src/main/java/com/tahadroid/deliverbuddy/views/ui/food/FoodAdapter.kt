package com.tahadroid.deliverbuddy.views.ui.food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.models.Food
import kotlinx.android.synthetic.main.layout_food_item.view.*


class FoodAdapter(val listener: (View, Food, Int) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.ProductViewHolder>() {
    private var data: List<Food> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_food_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(data: List<Food>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Food) = with(itemView) {

            food_image.setImageResource(item.mImage)
            food_tv.text = item.mName
            setOnClickListener {
                listener.invoke(it, item, adapterPosition)
            }
        }
    }
}