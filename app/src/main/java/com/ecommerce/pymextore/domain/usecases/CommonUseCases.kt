package com.ecommerce.pymextore.domain.usecases

import com.ecommerce.pymextore.data.di.model.CreateProductRequest
import com.ecommerce.pymextore.data.di.model.ProductCreateResponse
import com.ecommerce.pymextore.data.di.model.ProductResponse
import com.ecommerce.pymextore.domain.repositories.CommonRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetProduct @Inject constructor (private val commonRepository: CommonRepository){

    fun invoke(): Flowable<List<ProductResponse>>{
        return commonRepository.getProduct()
    }

    fun addProduct(createRequest: CreateProductRequest): Flowable<ProductCreateResponse>{
        return commonRepository.addProduct(createRequest = createRequest)
    }
}