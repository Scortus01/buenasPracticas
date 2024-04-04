package com.ecommerce.pymextore.data.repositories.datasources

import com.ecommerce.pymextore.data.di.model.CreateProductRequest
import com.ecommerce.pymextore.data.di.model.ProductCreateResponse
import com.ecommerce.pymextore.data.di.model.ProductResponse
import com.ecommerce.pymextore.data.network.CommonServices
import io.reactivex.Flowable

class CommonDataSource(private val commonServices: CommonServices) {

    fun getProduct(): Flowable<List<ProductResponse>>{
        return commonServices.getProduct()
    }

    fun addProduct(createRequest: CreateProductRequest): Flowable<ProductCreateResponse>{
        return commonServices.addProduct(createRequest = createRequest)
    }
}