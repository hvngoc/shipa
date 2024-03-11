package com.shipa.route.data.cache

/**
 * Created by hvngoc on 7/29/22
 */
interface FileServices {
    fun saveData(fileName: String, data: String)

    fun getData(fileName: String): String?
}