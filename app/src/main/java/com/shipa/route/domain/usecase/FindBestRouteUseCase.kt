package com.shipa.route.domain.usecase

import com.shipa.route.domain.model.RealPoint
import com.shipa.route.lib.TspDynamicProgrammingIterative
import com.shipa.route.util.DistanceUtil


/**
 * Created by hvngoc on 7/29/22
 */
class FindBestRouteUseCase : BaseUseCase<List<RealPoint>, List<RealPoint>>() {

    override suspend fun loadData(params: List<RealPoint>?): List<RealPoint>? {
        val listParams = params ?: return emptyList()

        val matrix: Array<IntArray> = Array(listParams.size) { IntArray(listParams.size) }

        listParams.forEachIndexed { index, node ->
            matrix[index][index] = 0
            for (i in index + 1 until listParams.size) {
                val nextNode = listParams[i]
                val dist = DistanceUtil.distance(
                    node.lat,
                    node.lon,
                    nextNode.lat,
                    nextNode.lon
                )
                matrix[index][i] = dist.toInt()
                matrix[i][index] = dist.toInt()

            }
        }

        val finder = TspDynamicProgrammingIterative( listParams.size, 0, matrix)
        val index = finder.tour
        val result = arrayListOf<RealPoint>()
        index.forEach {
            val item = listParams[it]
            result.add(item)
        }

        return result
    }
}