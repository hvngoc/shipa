package com.shipa.route.lib

/**
 * Created by hvngoc on 3/12/24
 * <a href="https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/TspDynamicProgrammingIterative.java">...</a>
 */
class TspDynamicRecursive(val N: Int, val START_NODE: Int, val distance: Array<IntArray>) {

    private var FINISHED_STATE = 0
    private var minTourCost = Double.POSITIVE_INFINITY

    private val tour: MutableList<Int> = ArrayList()
    private var ranSolver = false

    init {
        FINISHED_STATE = (1 shl N) - 1
    }

    // Returns the optimal tour for the traveling salesman problem.
    fun getTour(): List<Int> {
        if (!ranSolver) solve()
        return tour
    }

    // Returns the minimal tour cost.
    fun getTourCost(): Double {
        if (!ranSolver) solve()
        return minTourCost
    }

    fun solve() {

        // Run the solver
        var state = 1 shl START_NODE
        val memo = Array(N) {
            arrayOfNulls<Double>(
                1 shl N
            )
        }
        val prev = Array<Array<Int?>>(N) {
            arrayOfNulls(
                1 shl N
            )
        }
        minTourCost = tsp(START_NODE, state, memo, prev)

        // Regenerate path
        var index = START_NODE
        while (true) {
            tour.add(index)
            val nextIndex = prev[index][state] ?: break
            state = state or (1 shl nextIndex)
            index = nextIndex
        }
        tour.add(START_NODE)
        ranSolver = true
    }

    private fun tsp(
        i: Int,
        state: Int,
        memo: Array<Array<Double?>>,
        prev: Array<Array<Int?>>
    ): Double {

        // Done this tour. Return cost of going back to start node.
        if (state == FINISHED_STATE) return distance[i][START_NODE].toDouble()

        // Return cached answer if already computed.
        if (memo[i][state] != null) return memo[i][state]!!
        var minCost = Double.POSITIVE_INFINITY
        var index = -1
        for (next in 0 until N) {

            // Skip if the next node has already been visited.
            if (state and (1 shl next) != 0) continue
            val nextState = state or (1 shl next)
            val newCost = distance[i][next] + tsp(next, nextState, memo, prev)
            if (newCost < minCost) {
                minCost = newCost
                index = next
            }
        }
        prev[i][state] = index
        return minCost.also { memo[i][state] = it }
    }
}