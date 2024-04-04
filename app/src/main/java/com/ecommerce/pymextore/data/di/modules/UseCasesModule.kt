package com.ecommerce.pymextore.data.di.modules

import com.ecommerce.pymextore.domain.repositories.CommonRepository
import com.ecommerce.pymextore.domain.usecases.GetProduct
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Singleton
    @Provides
    fun providesGetProduct(commonRepository: CommonRepository): GetProduct =
        GetProduct(commonRepository = commonRepository)
}