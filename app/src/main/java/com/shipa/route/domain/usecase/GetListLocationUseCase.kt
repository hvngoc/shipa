package com.shipa.route.domain.usecase

import com.shipa.route.domain.repository.LocationRepository

/**
 * Created by hvngoc on 7/29/22
 */
class GetListLocationUseCase(private val repository: LocationRepository) :
    BaseUseCase<Any, List<Int>>() {

    override suspend fun loadData(params: Any?): List<Int>? {
        return repository.getListPoint()
    }
}