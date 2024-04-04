package com.ecommerce.pymextore.ui.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.ecommerce.pymextore.data.di.model.CreateProductRequest
import com.ecommerce.pymextore.databinding.ActivityCreateProductBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random

@AndroidEntryPoint
class CreateProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateProductBinding
    private val productsViewModel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindEvents()
    }

    private fun bindEvents() {
        binding.btnCreate.setOnClickListener {
            productsViewModel.addProduct(
                createRequest = CreateProductRequest(
                    id = Random().nextInt(100),
                    name = binding.etName.text.toString(),
                    image = "",
                    price = binding.etPrice.text.toString().toInt(),
                    description = binding.etDescription.text.toString(),
                    category = 6,
                    quantity = binding.etQuantity.text.toString().toInt()
                )
            )
        }
        productsViewModel.rCreateProducts.observe(this){
            if (it.success) Toast.makeText(this, "Producto creado", Toast.LENGTH_SHORT).show()
        }
        productsViewModel.rFailCreateProducts.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}