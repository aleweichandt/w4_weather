package com.example.androiddevchallenge.data.client

import com.example.androiddevchallenge.data.model.weather.core.WeatherConditionResponse
import com.example.androiddevchallenge.data.model.weather.current.CurrentWeatherMainResponse
import com.example.androiddevchallenge.data.model.weather.current.CurrentWeatherResponse

// TODO remove
val mockCurrentResponse = CurrentWeatherResponse(
    main = CurrentWeatherMainResponse(
        22.1f,
        25.2f,
        18.7f
    ),
    weather = listOf(
        WeatherConditionResponse(
            "clean"
        )
    ),
)
