package com.shipa.route.data.cache

import com.google.gson.Gson

/**
 * Created by hvngoc on 7/29/22
 */
class CacheServicesImpl(
    private val fileServices: FileServices,
    private val gson: Gson
) : CacheServices {
}