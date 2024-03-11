package com.shipa.route.presentation.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shipa.route.Demo
import com.shipa.route.domain.response.DataResult
import com.shipa.route.domain.usecase.GetListLocationUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

/**
 * Created by hvngoc on 7/29/22
 */
class MainViewModel(private val useCase: GetListLocationUseCase) : ViewModel(), KoinComponent {

    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        _data.value = DataResult.Error(error)
    }

    private val _data = MutableLiveData<DataResult>().apply {
        value = DataResult.Success(Demo.listDemo)
    }
    val data: LiveData<DataResult> = _data


    fun loadData() {
        viewModelScope.launch(Dispatchers.Main + exceptionHandler) {
            useCase.execute("", {
                _data.value = it
            }, {
                _data.value = it
            })
        }
    }
}