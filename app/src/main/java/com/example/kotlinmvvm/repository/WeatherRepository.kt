package com.example.kotlinmvvm.repository

import com.example.kotlinmvvm.api.ApiService
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getWeather() = apiService.getWeatherData()
}