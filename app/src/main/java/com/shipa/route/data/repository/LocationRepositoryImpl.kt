package com.shipa.route.data.repository

import com.google.gson.Gson
import com.shipa.route.data.cache.CacheServices
import com.shipa.route.data.services.WeatherServices
import com.shipa.route.domain.repository.LocationRepository

/**
 * Created by hvngoc on 7/29/22
 */
class LocationRepositoryImpl(
    gson: Gson,
    private val weatherServices: WeatherServices,
    private val cacheServices: CacheServices
) : BaseRepository(gson), LocationRepository {

    @Throws(Throwable::class)
    override fun getListPoint(): List<Int> {
//        val cache = cacheServices.getCache(query)
//        if (cache != null) {
//            return cache
//        }
        val raw = weatherServices.getListing(query = "query").execute()
        val data = networkTransform(raw)
//        cacheServices.saveWeather(query, data)
//        return data
        return emptyList()
    }
}