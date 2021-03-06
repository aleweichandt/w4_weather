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
package com.example.androiddevchallenge.domain.repository

import com.example.androiddevchallenge.domain.model.query.QueryState
import com.example.androiddevchallenge.domain.model.report.WeatherDayReport
import com.example.androiddevchallenge.domain.model.report.WeatherForecastReport
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepository(private val api: IWeatherApi) {
    var unit: TemperatureUnit = TemperatureUnit.Celsius

    suspend fun getCurrentReportFor(city: String): Flow<QueryState<WeatherDayReport>> =
        flow {
            emit(QueryState.Loading)
            api.getCurrentReportFor(city, unit)?.let {
                emit(QueryState.Success(it))
            } ?: emit(QueryState.Failure)
        }

    suspend fun getForecastReportFor(city: String): Flow<QueryState<WeatherForecastReport>> =
        flow {
            emit(QueryState.Loading)
            api.getForecastReportFor(city, unit)?.let {
                emit(QueryState.Success(it))
            } ?: emit(QueryState.Failure)
        }
}
