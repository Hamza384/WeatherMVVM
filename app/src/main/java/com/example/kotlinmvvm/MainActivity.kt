package com.example.kotlinmvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinmvvm.databinding.ActivityMainBinding
import com.example.kotlinmvvm.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherResponse.observe(
            this
        ) {
            binding.apply {
                tvTemperature.text = it.temperature
                tvDesc.text = it.description
                tvWind.text = it.wind
                val forecast1 = it.forecast[0]
                val forecast2 = it.forecast[1]
                val forecast3 = it.forecast[2]
                tvForecast1.text = "${forecast1.temperature} / ${forecast1.wind}"
                tvForecast2.text = "${forecast2.temperature} / ${forecast2.wind}"
                tvForecast3.text = "${forecast3.temperature} / ${forecast3.wind}"
            }
        }

    }
}