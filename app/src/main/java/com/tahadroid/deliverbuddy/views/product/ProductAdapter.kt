package com.tahadroid.deliverbuddy.views.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahadroid.deliverbuddy.R
import com.tahadroid.deliverbuddy.models.Product
import kotlinx.android.synthetic.main.layout_product_item.view.*


class ProductAdapter(val listener: (View, Product, Int) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var data: List<Product> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_product_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(data: List<Product>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Product) = with(itemView) {
            name_tv.text = item.mName
            description_tv.text = item.mDescription
            logo_image.setImageResource(item.image)
            time_tv.text = item.mTime
            setOnClickListener {
                listener.invoke(it, item, adapterPosition)
            }
        }
    }
}