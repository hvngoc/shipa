package com.shipa.route.util

import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Created by hvngoc on 3/6/24
 */
object DistanceUtil {

    fun distance(
        lat11: Double,
        lon11: Double,
        lat22: Double,
        lon22: Double
    ): Double {
        val lon1 = Math.toRadians(lon11)
        val lon2 = Math.toRadians(lon22)
        val lat1 = Math.toRadians(lat11)
        val lat2 = Math.toRadians(lat22)
        val deltaLong = lon2 - lon1
        val deltaLat = lat2 - lat1

        val a = sin(deltaLat / 2).pow(2.0) +
                cos(lat1) * cos(lat2) * sin(deltaLong / 2).pow(2.0)
        val c = 2 * asin(sqrt(a))
        val r = 6371.0
        return c * r * 1000
    }
}