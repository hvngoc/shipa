package com.shipa.route.presentation.di

import com.google.gson.Gson
import com.shipa.route.presentation.screen.main.MainViewModel
import com.shipa.route.presentation.screen.router.RouterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by hvngoc on 7/29/22
 */
val appModule = module {
    single { Gson() }

    viewModel { MainViewModel(get()) }
    viewModel { RouterViewModel(get()) }
}