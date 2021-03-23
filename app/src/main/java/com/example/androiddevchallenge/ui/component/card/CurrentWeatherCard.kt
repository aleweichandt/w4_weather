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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.model.report.WeatherDayReport
import com.example.androiddevchallenge.domain.model.weather.ClimateCondition
import com.example.androiddevchallenge.domain.model.weather.Temperature
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit
import com.example.androiddevchallenge.domain.model.weather.Weather
import com.example.androiddevchallenge.ui.component.icon.ClimateIcon
import com.example.androiddevchallenge.ui.component.text.TemperatureText
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun CurrentWeatherCard(
    modifier: Modifier = Modifier,
    city: String = "",
    report: WeatherDayReport
) {
    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = city,
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = stringResource(id = R.string.today),
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Start
            )
            ClimateIcon(
                modifier = Modifier.size(72.dp),
                condition = report.current.climate
            )
            Spacer(modifier = Modifier.height(8.dp))
            TemperatureText(
                modifier = Modifier.wrapContentSize(),
                temperature = report.current.temperature,
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TemperatureText(
                    modifier = Modifier.wrapContentSize(),
                    temperature = report.minTemperature,
                    style = MaterialTheme.typography.body2,
                    prefix = stringResource(id = R.string.min)
                )
                Spacer(modifier = Modifier.width(24.dp))
                TemperatureText(
                    modifier = Modifier.wrapContentSize(),
                    temperature = report.maxTemperature,
                    style = MaterialTheme.typography.body2,
                    prefix = stringResource(id = R.string.max)
                )
            }
        }
    }
}

@Preview
@Composable
fun WeatherReportCardPreview() {
    val temp = Temperature(23f, TemperatureUnit.Celsius)
    val report = WeatherDayReport(
        Weather(temp, ClimateCondition.Clean),
        temp,
        temp
    )
    MyTheme {
        CurrentWeatherCard(city = "Malaga", report = report)
    }
}
