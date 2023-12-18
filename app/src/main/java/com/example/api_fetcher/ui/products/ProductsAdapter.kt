package com.example.api_fetcher.ui.products

import com.example.api_fetcher.R
import com.example.api_fetcher.ui.base.BaseAdapter
import com.example.api_fetcher.ui.base.BaseInteractionListener
import com.example.api_fetcher.ui.products.productsUIState.ProductUIState

class ProductsAdapter(
    list : List<ProductUIState>,
    listener: ProductsClicksListener
) : BaseAdapter<ProductUIState>(list,listener) {
    override fun layoutId(): Int = R.layout.item_product
}

interface ProductsClicksListener : BaseInteractionListener {
    fun onListClick(item: ProductUIState)
}