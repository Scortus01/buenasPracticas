package com.ecommerce.pymextore.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ecommerce.pymextore.data.di.model.CreateProductRequest
import com.ecommerce.pymextore.data.di.model.ProductCreateResponse
import com.ecommerce.pymextore.data.di.model.ProductResponse
import com.ecommerce.pymextore.domain.usecases.GetProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getProduct: GetProduct): ViewModel() {

    private var responseProducts = MutableLiveData<List<ProductResponse>>()
    val rProducts: LiveData<List<ProductResponse>> = responseProducts
    private var responseFailProducts = MutableLiveData<String>()
    val rFailProducts: LiveData<String> = responseFailProducts
    private var responseCreateProduct = MutableLiveData<ProductCreateResponse>()
    val rCreateProducts: LiveData<ProductCreateResponse> = responseCreateProduct
    private var responseFailCreateProducts = MutableLiveData<String>()
    val rFailCreateProducts: LiveData<String> = responseFailCreateProducts
    private var loadingState = MutableLiveData<Boolean>()
    val rLoadingState: LiveData<Boolean> = loadingState

    fun getProducts(){
        getProduct.invoke().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loadingState.value = true }
            .subscribeBy(
                onNext = {
                    loadingState.value = false
                    responseProducts.value = it
                },
                onError = {
                    loadingState.value = false
                    responseFailProducts.value = it.message ?: it.toString()
                }
            )
    }

    fun addProduct(createRequest: CreateProductRequest){
        getProduct.addProduct(createRequest = createRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {  }
            .subscribeBy(
                onNext = {
                    if (it.success) responseCreateProduct.value = it
                    else responseFailCreateProducts.value = it.message
                },
                onError = {
                    responseFailCreateProducts.value = it.message ?: it.toString()
                }
            )
    }
}