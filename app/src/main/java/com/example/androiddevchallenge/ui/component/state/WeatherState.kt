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
package com.example.androiddevchallenge.ui.component.state

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.domain.model.query.QueryState
import com.example.androiddevchallenge.domain.model.query.QueryState.Failure
import com.example.androiddevchallenge.domain.model.query.QueryState.Loading
import com.example.androiddevchallenge.domain.model.query.QueryState.Success
import com.example.androiddevchallenge.domain.model.report.WeatherDayReport
import com.example.androiddevchallenge.ui.local.LocalWeatherRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun WeatherState(
    modifier: Modifier = Modifier,
    city: String = "",
) {
    val weatherRepository = LocalWeatherRepository.current
    val (state, setState) = rememberSaveable {
        mutableStateOf<QueryState<WeatherDayReport>>(
            QueryState.Ready
        )
    }
    val search = suspend {
        if (city.isNotBlank()) {
            weatherRepository.getCurrentReportFor(city = city).collect { setState(it) }
        }
    }
    LaunchedEffect(key1 = city, block = { search() })
    val scope = rememberCoroutineScope()

    Crossfade(
        modifier = modifier,
        targetState = state
    ) { nextState ->
        when (nextState) {
            is Loading -> WeatherLoadingState(
                modifier = Modifier.fillMaxSize(),
                city = city
            )
            is Failure -> WeatherFailureState(
                modifier = Modifier.fillMaxSize(),
                city = city,
                onRetry = {
                    scope.launch { search() }
                }
            )
            is Success -> WeatherSuccessState(
                modifier = Modifier.fillMaxSize(),
                city = city,
                dayReport = nextState.data
            )
            else -> WeatherReadyState(modifier = Modifier.fillMaxSize())
        }
    }
}
