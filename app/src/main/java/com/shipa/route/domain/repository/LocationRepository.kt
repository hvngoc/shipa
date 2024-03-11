package com.shipa.route.domain.repository

/**
 * Created by hvngoc on 7/29/22
 */
interface LocationRepository {

    @Throws(Throwable::class)
    fun getListPoint(): List<Int>
}