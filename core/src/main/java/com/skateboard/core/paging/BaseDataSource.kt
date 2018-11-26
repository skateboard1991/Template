package com.skateboard.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.ItemKeyedDataSource

abstract class BaseDataSource<Key, Value, Error> : ItemKeyedDataSource<Key, Value>() {

    val state = MutableLiveData<Int>()

    private var startIndex = 0


    override fun loadInitial(params: LoadInitialParams<Key>, callback: LoadInitialCallback<Value>) {

        state.postValue(PagingState.LOADING)
        fetchData(startIndex,::onSuccess,::onFailed,callback)
    }

    override fun loadAfter(params: LoadParams<Key>, callback: LoadCallback<Value>) {
        if (shouldLoadMore()) {
            state.postValue(PagingState.LOADING)
            fetchData(startIndex,::onSuccess,::onFailed,callback)
        }
    }

    override fun loadBefore(params: LoadParams<Key>, callback: LoadCallback<Value>) {

    }

    open fun shouldLoadMore() = true

    abstract fun fetchData(
            startIndex: Int, onSuccess:
            (
                    List<Value>,
                    LoadCallback<Value>
            ) -> Unit, onFailed: (Error) -> Unit, callback: LoadCallback<Value>
    )

    private fun onSuccess(dataList: List<Value>, callback: LoadCallback<Value>) {
        startIndex+=dataList.size
        callback.onResult(dataList)
        state.postValue(PagingState.LOADED)
    }

    private fun onFailed(error: Error) {

        state.postValue(PagingState.ERROR)
    }

}