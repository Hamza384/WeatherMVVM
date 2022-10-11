package com.example.kotlinmvvm.model

data class WeatherModel(
    val description: String,
    val forecast: List<Forecast>,
    val temperature: String,
    val wind: String
)