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
package com.example.androiddevchallenge.data.service

import com.example.androiddevchallenge.data.model.weather.current.CurrentWeatherResponse
import com.example.androiddevchallenge.data.model.weather.forecast.ForecastWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IOpenWeatherMapService {
    companion object {
        const val baseUrl = "https://api.openweathermap.org/"
    }

    @GET("/data/2.5/weather")
    suspend fun getCurrentWeatherFor(
        @Query("q") city: String,
        @Query("units") units: String,
        @Query("appid") key: String
    ): Response<CurrentWeatherResponse>

    @GET("/data/2.5/forecast/daily")
    suspend fun getForecastWeatherFor(
        @Query("q") city: String,
        @Query("cnt") days: Int,
        @Query("units") units: String,
        @Query("appid") key: String
    ): Response<ForecastWeatherResponse>
}
