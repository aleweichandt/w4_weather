/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
