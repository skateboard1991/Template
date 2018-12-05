package com.skateboard.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource

class StatusLoadInitialCallback<Key, Value>(
    val loadingDataState: MutableLiveData<Int>,
    val callback: PageKeyedDataSource.LoadInitialCallback<Key, Value>
) : PageKeyedDataSource.LoadInitialCallback<Key, Value>() {
    override fun onResult(
        data: MutableList<Value>,
        position: Int,
        totalCount: Int,
        previousPageKey: Key?,
        nextPageKey: Key?
    ) {
        callback.onResult(data, position, totalCount, previousPageKey, nextPageKey)
//        if (data.isEmpty()) {
        loadingDataState.postValue(LoadingDataState.LOADED)
//        }
    }

    override fun onResult(data: List<Value>, previousPageKey: Key?, nextPageKey: Key?) {
        callback.onResult(data, previousPageKey, nextPageKey)
//        if (data.isEmpty()) {
        loadingDataState.postValue(LoadingDataState.LOADED)
//        } else {

//    }
    }

    fun onError() {

        loadingDataState.postValue(LoadingDataState.ERROR)
    }
}