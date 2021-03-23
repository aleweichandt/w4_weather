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
package com.example.androiddevchallenge.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.androiddevchallenge.domain.model.query.QueryState
import com.example.androiddevchallenge.domain.model.report.WeatherDayReport
import com.example.androiddevchallenge.domain.model.report.WeatherForecastReport
import com.example.androiddevchallenge.ui.local.LocalWeatherRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

data class WeatherDataSourceResult(
    val dayReportState: QueryState<WeatherDayReport>,
    val forecastReportState: QueryState<WeatherForecastReport>,
    val retry: () -> Unit
)

@Composable
fun weatherDataSource(
    city: String = "",
): WeatherDataSourceResult {
    val weatherRepository = LocalWeatherRepository.current
    val scope = rememberCoroutineScope()
    val (dayReportState, setDayReportState) = rememberSaveable {
        mutableStateOf<QueryState<WeatherDayReport>>(QueryState.Ready)
    }
    val (forecastReportState, setForecastReportState) = rememberSaveable {
        mutableStateOf<QueryState<WeatherForecastReport>>(QueryState.Ready)
    }
    val search = suspend {
        if (city.isNotBlank()) {
            scope.launch {
                weatherRepository.getCurrentReportFor(city = city).collect {
                    setDayReportState(it)
                }
            }
            scope.launch {
                weatherRepository.getForecastReportFor(city = city)
                    .collect { setForecastReportState(it) }
            }
        }
    }
    LaunchedEffect(key1 = city, block = { search() })
    return WeatherDataSourceResult(
        dayReportState = dayReportState,
        forecastReportState = forecastReportState,
        retry = { scope.launch { search() } }
    )
}
