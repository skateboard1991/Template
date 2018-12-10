package com.jd.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource

class StatusLoadCallback<Key,Value>(val pagingState: MutableLiveData<Int>, val callback:PageKeyedDataSource.LoadCallback<Key,Value>):PageKeyedDataSource.LoadCallback<Key,Value>(){

    override fun onResult(data: List<Value>, adjacentPageKey: Key?) {
        callback.onResult(data,adjacentPageKey)
        if(data.isEmpty()){
            pagingState.postValue(LoadingDataState.LOADED)
        }
        else{

        }
    }

    fun onError(){

        pagingState.postValue(LoadingDataState.ERROR)
    }
}