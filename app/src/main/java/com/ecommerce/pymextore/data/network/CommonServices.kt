package com.ecommerce.pymextore.data.network

import com.ecommerce.pymextore.data.di.model.CreateProductRequest
import com.ecommerce.pymextore.data.di.model.ProductCreateResponse
import com.ecommerce.pymextore.data.di.model.ProductResponse
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CommonServices {

    @GET("product/")
    fun getProduct(): Flowable<List<ProductResponse>>

    @POST("product/add")
    fun addProduct(@Body createRequest: CreateProductRequest): Flowable<ProductCreateResponse>

}