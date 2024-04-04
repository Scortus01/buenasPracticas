package com.ecommerce.pymextore.domain.repositories

import com.ecommerce.pymextore.data.di.model.CreateProductRequest
import com.ecommerce.pymextore.data.di.model.ProductCreateResponse
import com.ecommerce.pymextore.data.di.model.ProductResponse
import io.reactivex.Flowable

interface CommonRepository {

    fun getProduct(): Flowable<List<ProductResponse>>

    fun addProduct(createRequest: CreateProductRequest): Flowable<ProductCreateResponse>
}