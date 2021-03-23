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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.component.search.SearchBar
import com.example.androiddevchallenge.ui.component.state.current.CurrentWeatherStateRender
import com.example.androiddevchallenge.ui.component.state.forecast.ForecastWeatherStateRender

@Composable
fun MainScreen() {
    val (city, setCity) = rememberSaveable { mutableStateOf("") }
    Scaffold(
        bottomBar = { MainScreenBottomBar(onSearch = setCity) }
    ) {
        MainScreenBody(city = city)
    }
}

@Composable
fun MainScreenBottomBar(onSearch: (String) -> Unit) {
    SearchBar(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        onSearch = onSearch
    )
}

@Composable
fun MainScreenBody(city: String) {
    val (dayReportState, forecastReportState, retry) = weatherDataSource(city = city)
    Column(modifier = Modifier.fillMaxSize()) {
        ForecastWeatherStateRender(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            state = forecastReportState
        )
        CurrentWeatherStateRender(
            modifier = Modifier
                .padding(bottom = 48.dp, start = 16.dp, end = 16.dp),
            city = city,
            state = dayReportState,
            onRetry = retry
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
