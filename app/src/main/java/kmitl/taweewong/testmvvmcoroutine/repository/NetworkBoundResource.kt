package kmitl.taweewong.testmvvmcoroutine.repository

import androidx.lifecycle.LiveData

abstract class NetworkBoundResource<RequestType, ResultType> {

    init {
        val data = loadFromDb()

        if (shouldFetch(data)) {
            //TODO: fetch from network
        } else {
            //TODO: fetch database
        }
    }

    protected abstract fun saveCallResult(item: RequestType)

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun loadFromDb(): ResultType

//    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
}