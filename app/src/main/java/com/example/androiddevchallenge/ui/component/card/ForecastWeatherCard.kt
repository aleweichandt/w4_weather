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
package com.example.androiddevchallenge.ui.component.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.model.weather.ClimateCondition
import com.example.androiddevchallenge.domain.model.weather.Temperature
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import com.example.androiddevchallenge.domain.model.weather.WeatherForecast
import com.example.androiddevchallenge.ui.component.text.TemperatureText
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ForecastWeatherCard(
    modifier: Modifier = Modifier,
    forecast: WeatherForecast
) {
    val dow = SimpleDateFormat("EEE", Locale.getDefault()).format(forecast.date)
    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = dow,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TemperatureText(
                    modifier = Modifier.wrapContentSize(),
                    temperature = forecast.minTemperature,
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = "/",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(8.dp))
                TemperatureText(
                    modifier = Modifier.wrapContentSize(),
                    temperature = forecast.maxTemperature,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview
@Composable
fun ForecastWeatherCardPreview() {
    val temp = Temperature(23f, TemperatureUnit.Celsius)
    val forecast = WeatherForecast(
        date = Date(),
        climate = ClimateCondition.Clean,
        maxTemperature = temp,
        minTemperature = temp
    )
    MyTheme {
        ForecastWeatherCard(forecast = forecast)
    }
}
