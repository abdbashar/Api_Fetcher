package com.example.api_fetcher.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.api_fetcher.BR

abstract class BaseAdapter<T>(
    private var itemsList: List<T>,
    private val listener: BaseInteractionListener,
) : RecyclerView.Adapter<BaseAdapter.ItemViewHolder>() {
    @LayoutRes
    abstract fun layoutId(): Int

    class ItemViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = itemsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId(),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.run {
          setVariable(BR.item, itemsList[position])
            setVariable(BR.listener, listener)
        }
    }

    open fun setItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(BaseDiffUtil(itemsList, newItems, ::areItemsSame, ::areContentSame))
        itemsList = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    open fun areItemsSame(oldItem: T, newItem: T): Boolean {
        return oldItem?.equals(newItem) == true
    }
    open fun areContentSame(oldPosition: T, newPosition: T) = true

}