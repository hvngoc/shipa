package com.shipa.route.presentation

import androidx.multidex.MultiDexApplication
import com.shipa.route.data.di.cacheModule
import com.shipa.route.data.di.networkModule
import com.shipa.route.data.di.repositoryModule
import com.shipa.route.domain.di.useCaseModule
import com.shipa.route.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by hvngoc on 7/29/22
 */
class MyApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appModule, networkModule, repositoryModule, useCaseModule, cacheModule)
        }
    }
}