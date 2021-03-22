package com.example.androiddevchallenge.data.client

import com.example.androiddevchallenge.data.model.weather.core.WeatherConditionResponse
import com.example.androiddevchallenge.data.model.weather.current.CurrentWeatherMainResponse
import com.example.androiddevchallenge.data.model.weather.current.CurrentWeatherResponse
import com.example.androiddevchallenge.data.model.weather.forecast.ForecastWeatherDayResponse
import com.example.androiddevchallenge.data.model.weather.forecast.ForecastWeatherResponse
import com.example.androiddevchallenge.data.model.weather.forecast.ForecastWeatherTempResponse
import java.util.concurrent.TimeUnit

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

val mockForecastResponse = ForecastWeatherResponse(
    list = listOf(
        ForecastWeatherDayResponse(
            dt = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1),
            temp = ForecastWeatherTempResponse(
                max = 26.1f,
                min = 12.8f
            ),
            weather = listOf(
                WeatherConditionResponse(
                    main = "clean"
                )
            )
        ),
        ForecastWeatherDayResponse(
            dt = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(2),
            temp = ForecastWeatherTempResponse(
                max = 26.1f,
                min = 12.8f
            ),
            weather = listOf(
                WeatherConditionResponse(
                    main = "clean"
                )
            )
        ),
        ForecastWeatherDayResponse(
            dt = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(3),
            temp = ForecastWeatherTempResponse(
                max = 26.1f,
                min = 12.8f
            ),
            weather = listOf(
                WeatherConditionResponse(
                    main = "clean"
                )
            )
        ),
        ForecastWeatherDayResponse(
            dt = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(4),
            temp = ForecastWeatherTempResponse(
                max = 26.1f,
                min = 12.8f
            ),
            weather = listOf(
                WeatherConditionResponse(
                    main = "clean"
                )
            )
        ),
        ForecastWeatherDayResponse(
            dt = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(5),
            temp = ForecastWeatherTempResponse(
                max = 26.1f,
                min = 12.8f
            ),
            weather = listOf(
                WeatherConditionResponse(
                    main = "clean"
                )
            )
        ),
        ForecastWeatherDayResponse(
            dt = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(6),
            temp = ForecastWeatherTempResponse(
                max = 26.1f,
                min = 12.8f
            ),
            weather = listOf(
                WeatherConditionResponse(
                    main = "clean"
                )
            )
        ),
        ForecastWeatherDayResponse(
            dt = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7),
            temp = ForecastWeatherTempResponse(
                max = 26.1f,
                min = 12.8f
            ),
            weather = listOf(
                WeatherConditionResponse(
                    main = "clean"
                )
            )
        )
    )
)
