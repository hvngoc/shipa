package com.shipa.route.domain.di

import com.shipa.route.domain.usecase.FindBestRouteUseCase
import com.shipa.route.domain.usecase.GetListLocationUseCase
import org.koin.dsl.module

/**
 * Created by hvngoc on 7/29/22
 */
val useCaseModule = module {
    single<GetListLocationUseCase> { GetListLocationUseCase(get()) }
    single<FindBestRouteUseCase> { FindBestRouteUseCase() }
}