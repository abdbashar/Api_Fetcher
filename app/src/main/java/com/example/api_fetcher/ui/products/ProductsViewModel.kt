package com.example.api_fetcher.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_fetcher.domain.CheckConnectivityUseCase
import com.example.api_fetcher.domain.GetProductsUseCase
import com.example.api_fetcher.ui.products.productUIMapper.ProductUIMapper
import com.example.api_fetcher.ui.products.productsUIState.GetProductsUIState
import com.example.api_fetcher.ui.products.productsUIState.ProductUIState
import com.example.api_fetcher.util.Event
import com.example.api_fetcher.util.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val productUIMapper: ProductUIMapper,
    private val checkConnectivityUseCase: CheckConnectivityUseCase
) : ViewModel(), ProductsClicksListener {

    private val _productsUIState = MutableStateFlow(GetProductsUIState())
    val productsUIState: StateFlow<GetProductsUIState> get() = _productsUIState

    private val _productItem = MutableLiveData<Event<ProductUIState>>()
    val productItem: LiveData<Event<ProductUIState>> get() = _productItem


    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            if (checkConnectivityUseCase()) {
                _productsUIState.update {
                    it.copy(
                        isLoading = true,
                        isInternetUnAvailable = false
                    )
                }
                try {
                    val products = getProductsUseCase().map {
                        productUIMapper.map(it)
                    }
                    _productsUIState.update {
                        it.copy(
                            isLoading = false,
                            isEmpty = products.isEmpty(),
                            isSuccess = true,
                            isFailure = false,
                            products = products
                        )
                    }
                } catch (e: Throwable) {
                    _productsUIState.update {
                        it.copy(
                            isLoading = false,
                            isSuccess = false,
                            isFailure = true,
                            error = e.message.toString()
                        )
                    }
                }
            } else {
                _productsUIState.update {
                    it.copy(
                        isLoading = false,
                        isInternetUnAvailable = true
                    )
                }
            }
        }
    }


    fun getData() {
        viewModelScope.launch {
            _productsUIState.update {
                it.copy(
                    isLoading = false,
                    isSuccess = false,
                    isFailure = false,
                )
            }
        }
        getProducts()
    }

    override fun onListClick(item: ProductUIState) {
        _productItem.postEvent(item)
    }
}