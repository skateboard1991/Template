package com.skateboard.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.skateboard.core.paging.PagingDataState

abstract class BaseDataSource<Key, Value>(val dataState: MutableLiveData<Int>) : PageKeyedDataSource<Key, Value>() {

    var retry: (() -> Any?)? = null

    override fun loadInitial(params: LoadInitialParams<Key>, callback: LoadInitialCallback<Key, Value>) {

        dataState.postValue(PagingDataState.LOADING)
        onLoadInitial(params, StatusLoadInitialCallback(dataState, callback))
    }

    abstract fun onLoadInitial(params: LoadInitialParams<Key>, callback: StatusLoadInitialCallback<Key, Value>)

    override fun loadAfter(params: LoadParams<Key>, callback: LoadCallback<Key, Value>) {

        dataState.postValue(PagingDataState.LOADING)
        val statusLoadCallback = StatusLoadCallback(dataState, callback)
        onLoadAfter(params, statusLoadCallback)
        retry = {
            onLoadAfter(params, statusLoadCallback)
        }
    }

    abstract fun onLoadAfter(params: LoadParams<Key>, callback: StatusLoadCallback<Key, Value>)

    override fun loadBefore(params: LoadParams<Key>, callback: LoadCallback<Key, Value>) {
        dataState.postValue(PagingDataState.LOADING)
        onLoadBefore(params, StatusLoadCallback(dataState, callback))
    }

    abstract fun onLoadBefore(params: LoadParams<Key>, callback: StatusLoadCallback<Key, Value>)

}