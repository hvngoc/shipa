package com.shipa.route.data.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hvngoc on 7/29/22
 */
interface WeatherServices {

    @GET("data/2.5/forecast/daily")
    fun getListing(
        @Query("q") query: String? = null,
        @Query("cnt") cnt: Int = 7,
        @Query("appid") appid: String = "",
    ): Call<Int>
}