package com.tahadroid.deliverbuddy.views.ui.personal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.models.Personal
import kotlinx.android.synthetic.main.layout_personal_item.view.*


class PersonalAdapter(val listener: (View, Personal, Int) -> Unit) :
    RecyclerView.Adapter<PersonalAdapter.ProductViewHolder>() {
    private var data: List<Personal> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_personal_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(data: List<Personal>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Personal) = with(itemView) {

            personal_image.setImageResource(item.image)
            priceTextView.text = item.price.toString()
            nameTextView.text = item.name
            setOnClickListener {
                listener.invoke(it, item, adapterPosition)
            }
        }
    }
}