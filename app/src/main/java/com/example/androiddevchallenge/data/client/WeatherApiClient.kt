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

import com.example.androiddevchallenge.data.service.IOpenWeatherMapService
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import com.example.androiddevchallenge.domain.repository.IWeatherApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class WeatherApiClient(
    private val service: IOpenWeatherMapService,
    private val apiKey: String,
) : IWeatherApi {
    companion object {
        fun buildWith(apiKey: String): WeatherApiClient {
            val retrofit = Retrofit.Builder()
                .baseUrl(IOpenWeatherMapService.baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service = retrofit.create(IOpenWeatherMapService::class.java)
            return WeatherApiClient(service = service, apiKey = apiKey)
        }
    }

    override suspend fun getCurrentReportFor(
        city: String,
        unit: TemperatureUnit
    ) = service.getCurrentWeatherFor(
        city = city, key = apiKey, units = unit.system
    ).body()?.toWeatherDailyReport(unit)

    override suspend fun getForecastReportFor(
        city: String,
        unit: TemperatureUnit
    ) = service.getForecastWeatherFor(
        city = city, key = apiKey, days = 7, units = unit.system
    ).body()?.toWeatherForecastReport(unit)
}
