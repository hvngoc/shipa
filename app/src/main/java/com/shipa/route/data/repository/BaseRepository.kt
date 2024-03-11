package com.shipa.route.data.repository

import com.google.gson.Gson
import com.shipa.route.domain.error.MasterThrowable
import com.shipa.route.domain.response.CommonError
import retrofit2.Response

/**
 * Created by hvngoc on 7/29/22
 */
abstract class BaseRepository(private val gson: Gson) {

    @Throws(Throwable::class)
    protected fun <T> networkTransform(response: Response<T?>): T {
        if (response.isSuccessful) {
            response.body()?.let {
                return it
            } ?: run {
                val unknownError = CommonError("-1", "System went wrong!.")
                throw MasterThrowable(unknownError)
            }
        } else {
            val error: CommonError =
                gson.fromJson(response.errorBody()!!.charStream(), CommonError::class.java)
            throw MasterThrowable(error)
        }
    }
}