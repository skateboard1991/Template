package com.skateboard.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource

abstract class BaseDataSource<Key, Value>(val loadingDataState: MutableLiveData<Int>) : PageKeyedDataSource<Key, Value>()
{

    var retry: (() -> Any?)? = null

    override fun loadInitial(params: LoadInitialParams<Key>, callback: LoadInitialCallback<Key, Value>)
    {

        loadingDataState.postValue(LoadingDataState.LOADING)
        onLoadInitial(params, StatusLoadInitialCallback(loadingDataState, callback))
        retry = {
            loadInitial(params, callback)
        }
    }

    abstract fun onLoadInitial(params: LoadInitialParams<Key>, callback: StatusLoadInitialCallback<Key, Value>)

    override fun loadAfter(params: LoadParams<Key>, callback: LoadCallback<Key, Value>)
    {

        loadingDataState.postValue(LoadingDataState.LOADING)
        val statusLoadCallback = StatusLoadCallback(loadingDataState, callback)
        retry = {
            loadAfter(params, callback)
        }
        onLoadAfter(params, statusLoadCallback)

    }

    abstract fun onLoadAfter(params: LoadParams<Key>, callback: StatusLoadCallback<Key, Value>)

    override fun loadBefore(params: LoadParams<Key>, callback: LoadCallback<Key, Value>)
    {
        loadingDataState.postValue(LoadingDataState.LOADING)
        retry = {
            loadBefore(params, callback)
        }
        onLoadBefore(params, StatusLoadCallback(loadingDataState, callback))
    }

    abstract fun onLoadBefore(params: LoadParams<Key>, callback: StatusLoadCallback<Key, Value>)

}