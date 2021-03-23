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
package com.example.androiddevchallenge.data.model.weather.forecast

import com.example.androiddevchallenge.data.model.weather.core.WeatherConditionResponse
import com.example.androiddevchallenge.domain.model.weather.Temperature
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import com.example.androiddevchallenge.domain.model.weather.WeatherForecast
import java.util.Date

data class ForecastWeatherDayResponse(
    val dt: Long,
    val temp: ForecastWeatherTempResponse,
    val weather: List<WeatherConditionResponse>
) {
    fun toWeatherForecast(unit: TemperatureUnit): WeatherForecast =
        WeatherForecast(
            date = Date(dt * 1000),
            climate = weather[0].toClimateCondition(),
            maxTemperature = Temperature(temp.max, unit),
            minTemperature = Temperature(temp.min, unit)
        )
}
