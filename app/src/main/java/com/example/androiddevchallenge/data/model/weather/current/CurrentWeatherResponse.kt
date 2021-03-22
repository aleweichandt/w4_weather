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
package com.example.androiddevchallenge.data.model.weather.current

import com.example.androiddevchallenge.data.model.weather.core.WeatherConditionResponse
import com.example.androiddevchallenge.domain.model.report.WeatherDayReport
import com.example.androiddevchallenge.domain.model.weather.Temperature
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import com.example.androiddevchallenge.domain.model.weather.Weather

data class CurrentWeatherResponse(
    val main: CurrentWeatherMainResponse,
    val weather: List<WeatherConditionResponse>
) {
    fun toWeatherDailyReport(unit: TemperatureUnit): WeatherDayReport =
        WeatherDayReport(
            current = Weather(
                temperature = Temperature(main.temp, unit),
                climate = weather[0].toClimateCondition()
            ),
            maxTemperature = Temperature(main.maxTemp, unit),
            minTemperature = Temperature(main.minTemp, unit)
        )
}
