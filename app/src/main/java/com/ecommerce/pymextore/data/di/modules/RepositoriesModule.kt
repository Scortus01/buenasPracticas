package com.ecommerce.pymextore.data.di.modules

import com.ecommerce.pymextore.data.network.CommonServices
import com.ecommerce.pymextore.data.repositories.CommonRepositoryImp
import com.ecommerce.pymextore.data.repositories.datasources.CommonDataSource
import com.ecommerce.pymextore.domain.repositories.CommonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Singleton
    @Provides
    fun providesCommonRepository(commonDataSource: CommonDataSource): CommonRepository = CommonRepositoryImp(commonDataSource)

    @Singleton
    @Provides
    fun providesCommonDataSource(commonServices: CommonServices) : CommonDataSource
            = CommonDataSource(commonServices = commonServices)
}