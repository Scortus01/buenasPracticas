package com.ecommerce.pymextore.data.repositories

import com.ecommerce.pymextore.data.di.model.CreateProductRequest
import com.ecommerce.pymextore.data.di.model.ProductCreateResponse
import com.ecommerce.pymextore.data.di.model.ProductResponse
import com.ecommerce.pymextore.data.repositories.datasources.CommonDataSource
import com.ecommerce.pymextore.domain.repositories.CommonRepository
import io.reactivex.Flowable

class CommonRepositoryImp(private val commonDataSource: CommonDataSource): CommonRepository {

    override fun getProduct(): Flowable<List<ProductResponse>> {
        return commonDataSource.getProduct()
    }

    override fun addProduct(createRequest: CreateProductRequest): Flowable<ProductCreateResponse> {
        return commonDataSource.addProduct(createRequest = createRequest)
    }


}