package com.ecommerce.pymextore.ui.products

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.ecommerce.pymextore.databinding.ActivityProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    private val productsViewModel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindEvents()
    }

    private fun bindEvents() {
        binding.btnCreate.setOnClickListener {
            startActivity(Intent(this, CreateProductActivity::class.java))
        }
        productsViewModel.getProducts()
        productsViewModel.rProducts.observe(this){
            val adapter = ProductsAdapter(products = it)
            binding.rvProducts.adapter = adapter
        }
        productsViewModel.rFailProducts.observe(this){
            Toast.makeText(this, "Falló", Toast.LENGTH_SHORT).show()
        }
    }

}