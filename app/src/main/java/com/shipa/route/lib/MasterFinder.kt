package com.shipa.route.lib

import android.util.Log

/**
 * Created by hvngoc on 3/8/24
 */
class MasterFinder(
    private val matrix: Array<IntArray>,
    private val size: Int
) {

    fun getVertex(): List<Int> {
        val visited = arrayListOf(0)
        var lastDistance = Int.MAX_VALUE
        var result = listOf<Int>()
        buildVertex(visited) {
            val dist = getDistance(it)
            Log.i("conconheo2", dist.toString())
            if (dist < lastDistance) {
                lastDistance = dist
                result = it
            }
        }
        return result
    }

    private fun buildVertex(visited: ArrayList<Int>, callback: (List<Int>) -> Unit) {
        Log.i("heoheo", visited.toString())
        if (visited.size == size) {
            callback.invoke(visited.map { it })
            return
        }
        for (i in 1 until size) {
            if (!visited.contains(i)) {
                visited.add(i)
                buildVertex(visited, callback)
                visited.remove(i)
            }
        }
    }

    private fun getDistance(list: List<Int>): Int {
        var result = 0
        for (i in 0 until list.size - 1) {
            result += matrix[list[i]][list[i + 1]]
        }
        return result
    }

}