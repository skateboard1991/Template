package com.jd.core.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

abstract class BaseDataSourceFactory<Key, Value>(val loadingDataState: MutableLiveData<Int>) :
    DataSource.Factory<Key, Value>() {

    private var source: BaseDataSource<Key, Value>? = null

    override fun create(): BaseDataSource<Key, Value> {

        val dataSource = generateDataSource()
        source = dataSource
        return dataSource
    }

    open fun refresh() {

        source?.invalidate()
    }

    open fun retry() {
        source?.retry?.invoke()
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

        return Listing(pagedList, boundaryCallback.pagingState, loadingDataState, this::retry,this::refresh)
    }
}