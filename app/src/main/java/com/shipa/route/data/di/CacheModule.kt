package com.shipa.route.data.di

import com.shipa.route.data.cache.CacheServices
import com.shipa.route.data.cache.CacheServicesImpl
import com.shipa.route.data.cache.FileServices
import com.shipa.route.data.cache.FileServicesImpl
import org.koin.dsl.module

/**
 * Created by hvngoc on 7/29/22
 */
val cacheModule = module {
    single<FileServices> { FileServicesImpl(get()) }
    single<CacheServices> { CacheServicesImpl(get(), get()) }
}