package com.skateboard.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList

class StatueBoundaryCallback<T>: PagedList.BoundaryCallback<T>() {

    val pagingState=MutableLiveData<Int>()
    
    override fun onZeroItemsLoaded() {
        pagingState.postValue(PagingState.INIT_ERROR)
    }

    override fun onItemAtEndLoaded(itemAtEnd: T) {
        pagingState.postValue(PagingState.AT_BOTTOM)
    }

    override fun onItemAtFrontLoaded(itemAtFront: T) {

        pagingState.postValue(PagingState.AT_TOP)
    }
}