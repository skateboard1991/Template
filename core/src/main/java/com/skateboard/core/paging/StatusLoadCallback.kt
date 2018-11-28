package com.skateboard.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource

class StatusLoadCallback<Key,Value>(val pagingState: MutableLiveData<Int>, val callback:PageKeyedDataSource.LoadCallback<Key,Value>):PageKeyedDataSource.LoadCallback<Key,Value>(){

    override fun onResult(data: List<Value>, adjacentPageKey: Key?) {
        callback.onResult(data,adjacentPageKey)
        if(data.isEmpty()){
            pagingState.postValue(PagingDataState.LOADED)
        }
        else{

        }
    }

    fun onError(){

        pagingState.postValue(PagingDataState.ERROR)
    }
}