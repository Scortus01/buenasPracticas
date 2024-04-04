package com.ecommerce.pymextore.data.di.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id") val productId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("imageURL") val image: String,
    @SerializedName("price") val price: Int,
    @SerializedName("description") val description: String,
    @SerializedName("categoryId") val category: Int,
    @SerializedName("quantity") val quantity: Int
)

data class CreateProductRequest(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("imageURL") var image: String,
    @SerializedName("price") var price: Int,
    @SerializedName("description") var description: String,
    @SerializedName("categoryId") var category: Int,
    @SerializedName("quantity") var quantity: Int
)

data class ProductCreateResponse(
    @SerializedName("success") var success: Boolean,
    @SerializedName("message") var message: String,
    @SerializedName("time") var time: String
)