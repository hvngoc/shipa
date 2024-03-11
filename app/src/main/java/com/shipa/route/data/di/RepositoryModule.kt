package com.shipa.route.data.di

import com.shipa.route.data.repository.LocationRepositoryImpl
import com.shipa.route.domain.repository.LocationRepository
import org.koin.dsl.module

/**
 * Created by hvngoc on 7/29/22
 */
val repositoryModule = module {
    single<LocationRepository> { LocationRepositoryImpl(get(), get(), get()) }
}