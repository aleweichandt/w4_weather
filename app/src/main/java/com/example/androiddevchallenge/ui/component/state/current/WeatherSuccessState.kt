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
package com.example.androiddevchallenge.ui.component.state.current

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.model.report.WeatherDayReport
import com.example.androiddevchallenge.domain.model.weather.ClimateCondition
import com.example.androiddevchallenge.domain.model.weather.Temperature
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import com.example.androiddevchallenge.domain.model.weather.Weather
import com.example.androiddevchallenge.ui.component.card.CurrentWeatherCard
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WeatherSuccessState(
    modifier: Modifier = Modifier,
    city: String = "",
    dayReport: WeatherDayReport
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        CurrentWeatherCard(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            report = dayReport,
            city = city
        )
    }
}

@Preview
@Composable
fun WeatherSuccessStatePreview() {
    val temp = Temperature(23f, TemperatureUnit.Celsius)
    val report = WeatherDayReport(
        Weather(temp, ClimateCondition.Clean),
        temp,
        temp
    )
    MyTheme {
        WeatherSuccessState(
            city = "Malaga",
            dayReport = report
        )
    }
}
