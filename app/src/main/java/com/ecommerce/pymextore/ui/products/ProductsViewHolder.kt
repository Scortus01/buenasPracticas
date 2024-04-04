package com.ecommerce.pymextore.ui.products

import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.pymextore.data.di.model.ProductResponse
import com.ecommerce.pymextore.databinding.ItemProductsBinding

class ProductsViewHolder(private val binding: ItemProductsBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(product: ProductResponse){
        binding.apply {
            tvNombre.text = product.name
            tvDescription.text = product.description
            tvPrice.text = product.price.toString()
            tvQuantity.text = product.quantity.toString()
        }
    }
}