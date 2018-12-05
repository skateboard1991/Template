package com.skateboard.core.paging

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList

class Listing<T>(
    val pagedList: LiveData<PagedList<T>>,
    val pagingState: MutableLiveData<Int>,
    val loadingDataState: MutableLiveData<Int>,
    val retry: (() -> Any?)? = null,
    val refresh: (() -> Unit)? = null
) {

    var onStateListener: OnStateListener<T>? = null

    interface OnStateListener<T> {

        fun onPagedListLoaded(pagedList: PagedList<T>)

        fun onDataLoading()

        fun onDataLoaded()

        fun onDataError()

        fun onPagingBottom()

        fun onPagingTop()

        fun onPagingInitZero()
    }


    fun observe(owner: LifecycleOwner) {
        observePagedList(owner)
        observeLoadingDataState(owner)
        observePagingState(owner)
    }

    private fun observePagedList(owner: LifecycleOwner) {

        pagedList.observe(owner, Observer {

            onStateListener?.onPagedListLoaded(it)
        })
    }

    private fun observePagingState(owner: LifecycleOwner) {

        pagingState.observe(owner, Observer {

            when (it) {

                PagingState.INIT_ERROR -> onStateListener?.onPagingInitZero()

                PagingState.AT_TOP -> onStateListener?.onPagingTop()

                PagingState.AT_BOTTOM -> onStateListener?.onPagingBottom()
            }

        })
    }

    private fun observeLoadingDataState(owner: LifecycleOwner) {

        loadingDataState.observe(owner, Observer {

            when (it) {

                LoadingDataState.LOADING -> {
                    onStateListener?.onDataLoading()
                }

                LoadingDataState.LOADED -> {
                    onStateListener?.onDataLoaded()
                }

                LoadingDataState.ERROR -> {
                    onStateListener?.onDataError()
                }
            }

        })
    }

}

open class SimpleOnStateListener<T> : Listing.OnStateListener<T> {

    override
    fun onPagedListLoaded(pagedList: PagedList<T>) {

    }

    override fun onDataLoading() {

    }

    override fun onDataLoaded() {

    }

    override fun onDataError() {

    }

    override fun onPagingBottom() {

    }

    override fun onPagingTop() {

    }

    override fun onPagingInitZero() {

    }

}