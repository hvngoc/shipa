package com.shipa.route.presentation.screen.router

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shipa.route.Demo
import com.shipa.route.domain.response.DataResult
import com.shipa.route.domain.usecase.FindBestRouteUseCase
import com.shipa.route.domain.usecase.GetListLocationUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

/**
 * Created by hvngoc on 7/29/22
 */
class RouterViewModel(
    private val routeUseCase: FindBestRouteUseCase
) : ViewModel(), KoinComponent {

    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        _data.value = DataResult.Error(error)
    }

    private val _data = MutableLiveData<DataResult>()
    val data: LiveData<DataResult> = _data


    fun loadData() {
        viewModelScope.launch(Dispatchers.Main + exceptionHandler) {
            routeUseCase.execute(Demo.listDemo, {
                _data.value = it
            }, {
                _data.value = it
            })
        }
    }
}