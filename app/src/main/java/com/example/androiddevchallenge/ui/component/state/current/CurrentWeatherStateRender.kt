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

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.domain.model.query.QueryState
import com.example.androiddevchallenge.domain.model.report.WeatherDayReport
import com.example.androiddevchallenge.ui.component.state.QueryStateRender

@Composable
fun CurrentWeatherStateRender(
    modifier: Modifier = Modifier,
    city: String = "",
    state: QueryState<WeatherDayReport>,
    onRetry: () -> Unit = {},
) {
    QueryStateRender(
        modifier = modifier,
        state = state,
        onReady = {
            WeatherReadyState(modifier = Modifier.fillMaxSize())
        },
        onLoading = {
            WeatherLoadingState(modifier = Modifier.fillMaxSize(), city = city)
        },
        onFailure = {
            WeatherFailureState(
                modifier = Modifier.fillMaxSize(),
                city = city,
                onRetry = onRetry
            )
        },
        onSuccess = { report ->
            WeatherSuccessState(
                modifier = Modifier.fillMaxSize(),
                city = city,
                dayReport = report
            )
        }
    )
}
