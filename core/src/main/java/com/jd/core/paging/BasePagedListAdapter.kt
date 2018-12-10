package com.jd.core.paging

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

abstract class BasePagedListAdapter<T>(
    diffCallback: DiffUtil.ItemCallback<T>,
    var retry: (() -> Any?)? = null
) :
    PagedListAdapter<T, RecyclerView.ViewHolder>(diffCallback) {

    var state = LoadingDataState.LOADING

    companion object {

        val DATA_ITEM = 10

        val LOADING_ITEM = 11

        val ERROR_ITEM = 12
    }


    override fun getItemViewType(position: Int): Int {

        if (hasExtra() && position == itemCount - 1) {

            if (state == LoadingDataState.LOADING) {
                return LOADING_ITEM
            } else if (state == LoadingDataState.ERROR) {
                return ERROR_ITEM
            }
        }
        return DATA_ITEM
    }

    override fun getItemCount(): Int {

        return if (hasExtra()) super.getItemCount() + 1 else super.getItemCount()
    }

    protected open fun hasExtra(): Boolean {

        return state != LoadingDataState.LOADED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {

            DATA_ITEM -> return getDateItemViewHolder(parent, viewType)

            ERROR_ITEM -> return getErrorItemViewHolder(parent, viewType)

            LOADING_ITEM -> return getLoadingItemViewHolder(parent, viewType)
        }

        throw IllegalArgumentException("Unknown view type $viewType")

    }

    abstract fun getDateItemViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    abstract fun getErrorItemViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    abstract fun getLoadingItemViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    fun updateState(state: Int) {
        this.state=state
        if (state == LoadingDataState.ERROR || state == LoadingDataState
                .LOADING
        ) {
            notifyItemInserted(itemCount)
        }
        else{
            notifyItemRemoved(itemCount)
        }
    }
}