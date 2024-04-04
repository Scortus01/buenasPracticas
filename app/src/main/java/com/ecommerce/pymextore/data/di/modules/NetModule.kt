package com.ecommerce.pymextore.data.di.modules

import com.ecommerce.pymextore.data.network.CommonServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun providesRetrofitGetUrl() : Retrofit {
        val client = OkHttpClient.Builder()
            .connectTimeout(600, TimeUnit.SECONDS)
            .readTimeout(600, TimeUnit.SECONDS)
            .writeTimeout(600, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor {
                val request = it.request().newBuilder()
                    .build()
                it.proceed(request)
            }.build()

        return Retrofit.Builder()
            .baseUrl("https://softwarev-production.up.railway.app/")
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofitHolder() : RetrofitHolder {
        return RetrofitHolder()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object CommonServiceHolderModule{
    @Provides
    @Singleton
    fun providesCommonServiceHolder(retrofitHolder: RetrofitHolder) : CommonServices{
        return retrofitHolder.retrofit.create(CommonServices::class.java)
    }
}