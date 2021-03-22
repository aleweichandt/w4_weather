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

import com.example.androiddevchallenge.data.model.WeatherConditionResponse
import com.example.androiddevchallenge.data.model.WeatherMainResponse
import com.example.androiddevchallenge.data.model.WeatherResponse
import com.example.androiddevchallenge.domain.model.report.WeatherReport
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import com.example.androiddevchallenge.domain.repository.IWeatherApi
import kotlinx.coroutines.delay

class WeatherApiClient : IWeatherApi {
    // TODO remove
    private val mockResponse = WeatherResponse(
        main = WeatherMainResponse(
            22.1f,
            25.2f,
            18.7f
        ),
        weather = WeatherConditionResponse(
            "clean"
        ),
    )

    override suspend fun getCurrentReportFor(
        city: String,
        unit: TemperatureUnit
    ): WeatherReport? {
        delay(3000L) // TODO remove
        if (city.length < 3) {
            return null
        }
        return mockResponse.toWeatherDailyReport(unit)
    }
}
