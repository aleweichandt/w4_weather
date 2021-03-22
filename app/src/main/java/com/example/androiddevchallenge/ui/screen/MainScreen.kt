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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.model.query.QueryState
import com.example.androiddevchallenge.domain.model.report.WeatherReport
import com.example.androiddevchallenge.ui.component.search.SearchBar
import com.example.androiddevchallenge.ui.component.state.WeatherState
import com.example.androiddevchallenge.ui.local.LocalWeatherRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val weatherRepository = LocalWeatherRepository.current
    val (city, setCity) = remember { mutableStateOf("") }
    val (state, setState) = remember { mutableStateOf<QueryState<WeatherReport>>(QueryState.Ready) }
    val search = suspend {
        if (city.isNotBlank()) {
            weatherRepository.getReportFor(city = city).collect { setState(it) }
        }
    }
    LaunchedEffect(key1 = city, block = { search() })
    Scaffold(
        modifier = Modifier.padding(8.dp),
        bottomBar = { MainScreenBottomBar(onSearch = setCity) }
    ) {
        MainScreenBody(state = state, city = city, retry = search)
    }
}

@Composable
fun MainScreenBottomBar(onSearch: (String) -> Unit) {
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onSearch = onSearch
    )
}

@Composable
fun MainScreenBody(state: QueryState<WeatherReport>, city: String, retry: suspend () -> Unit) {
    val scope = rememberCoroutineScope()
    WeatherState(
        modifier = Modifier
            .fillMaxWidth(),
        state = state,
        city = city,
        onRetry = { scope.launch { retry() } }
    )
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
