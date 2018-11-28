package com.skateboard.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource

class StatusLoadInitialCallback<Key, Value>(
    val pagingState: MutableLiveData<Int>,
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
        if (data.isEmpty()) {
            pagingState.postValue(PagingDataState.LOADED)
        }
    }

    override fun onResult(data: List<Value>, previousPageKey: Key?, nextPageKey: Key?) {
        callback.onResult(data, previousPageKey, nextPageKey)
        if (data.isEmpty()) {
            pagingState.postValue(PagingDataState.LOADED)
        } else {

        }
    }
}