package com.example.api_fetcher.ui.products

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.api_fetcher.R
import com.example.api_fetcher.databinding.FragmentProductsBinding
import com.example.api_fetcher.ui.base.BaseFragment
import com.example.api_fetcher.util.observeEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_products

    override val viewModel: ProductsViewModel by viewModels()

    private lateinit var productsAdapter: ProductsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        observeUIState()
        onEvent()
    }

    private fun observeUIState() {
        lifecycleScope.launch {
            viewModel.productsUIState.collect { uiState ->
                uiState.products.let { storeProducts -> productsAdapter.setItems(storeProducts) }
            }
        }
    }

    private fun setAdapter() {
        productsAdapter = ProductsAdapter(emptyList(), viewModel)
        binding.storeProducts.adapter = productsAdapter
    }

    private fun onEvent() {
        viewModel.productItem.observeEvent(viewLifecycleOwner) { product ->
            showToastMessage(product.title)
        }
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}