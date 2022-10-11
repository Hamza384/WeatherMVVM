package com.example.kotlinmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmvvm.model.WeatherModel
import com.example.kotlinmvvm.repository.WeatherRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel
@Inject
constructor(private val weatherRepository: WeatherRepository) : ViewModel() {


    private val response = MutableLiveData<WeatherModel>()
    val weatherResponse: LiveData<WeatherModel>
        get() = response

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        weatherRepository.getWeather().let {
            if(it.isSuccessful){
                response.postValue(it.body())
            } else {
                Log.d("TAG", "getWeather Error "+it.errorBody())
            }
        }
    }

}