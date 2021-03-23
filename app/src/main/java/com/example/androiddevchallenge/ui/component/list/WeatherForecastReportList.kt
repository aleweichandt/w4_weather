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
package com.example.androiddevchallenge.ui.component.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.model.report.WeatherForecastReport
import com.example.androiddevchallenge.domain.model.weather.ClimateCondition
import com.example.androiddevchallenge.domain.model.weather.Temperature
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import com.example.androiddevchallenge.domain.model.weather.WeatherForecast
import com.example.androiddevchallenge.ui.component.card.ForecastWeatherCard
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Date

@Composable
fun WeatherForecastReportList(
    modifier: Modifier = Modifier,
    report: WeatherForecastReport
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = stringResource(id = R.string.next_days),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Start
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
            ) {
                report.days.map { forecast ->
                    item {
                        ForecastWeatherCard(
                            modifier = Modifier.padding(8.dp),
                            forecast = forecast
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun WeatherForecastReportListPreview() {
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
        WeatherForecastReportList(report = report)
    }
}
