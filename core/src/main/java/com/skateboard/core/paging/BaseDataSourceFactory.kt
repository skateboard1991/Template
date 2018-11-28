package com.skateboard.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

abstract class BaseDataSourceFactory<Key, Value>(val pagingDataState: MutableLiveData<Int>) :
    DataSource.Factory<Key, Value>() {

    val source = MutableLiveData<BaseDataSource<Key, Value>>()

    override fun create(): BaseDataSource<Key, Value> {

        val dataSource = generateDataSource()
        source.postValue(dataSource)
        return dataSource
    }

    abstract fun generateDataSource(): BaseDataSource<Key, Value>

    open fun generateListing(
        pageSize: Int = 30,
        prefecthDistance: Int = -1,
        enablePlaceHolders: Boolean = false,
        initialLoadSizeHint: Int = 2
    ): Listing<Value> {
        val boundaryCallback = StatueBoundaryCallback<Value>()
        val pagedList = LivePagedListBuilder(
            this,
            PagedList.Config.Builder().setPageSize(pageSize).setPrefetchDistance(prefecthDistance).setEnablePlaceholders(
                enablePlaceHolders
            ).setInitialLoadSizeHint(initialLoadSizeHint).build()
        ).setBoundaryCallback(
            boundaryCallback
        ).build()

        return Listing(pagedList, boundaryCallback.pagingState, pagingDataState, { source.value?.retry }, {
            source.value?.invalidate()
        })
    }
}