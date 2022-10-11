package com.example.kotlinmvvm.api

import com.example.kotlinmvvm.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/Curitiba")
    suspend fun getWeatherData(): Response<WeatherModel>

}