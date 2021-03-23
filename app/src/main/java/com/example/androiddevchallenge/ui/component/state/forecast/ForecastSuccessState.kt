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
package com.example.androiddevchallenge.ui.component.state.forecast

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.domain.model.report.WeatherForecastReport
import com.example.androiddevchallenge.domain.model.weather.ClimateCondition
import com.example.androiddevchallenge.domain.model.weather.Temperature
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import com.example.androiddevchallenge.domain.model.weather.WeatherForecast
import com.example.androiddevchallenge.ui.component.list.WeatherForecastReportList
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Date

@Composable
fun ForecastSuccessState(
    modifier: Modifier = Modifier,
    report: WeatherForecastReport
) {
    WeatherForecastReportList(
        modifier = modifier,
        report = report
    )
}

@Preview
@Composable
fun ForecastSuccessStatePreview() {
    val temp = Temperature(23f, TemperatureUnit.Celsius)
    val forecast = WeatherForecast(
        date = Date(),
        climate = ClimateCondition.Clean,
        maxTemperature = temp,
        minTemperature = temp
    )
    val report = WeatherForecastReport(
        days = listOf(forecast, forecast, forecast)
    )
    MyTheme {
        ForecastSuccessState(report = report)
    }
}
