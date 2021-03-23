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
package com.example.androiddevchallenge.data.model.weather.core

import com.example.androiddevchallenge.domain.model.weather.ClimateCondition
import java.util.Locale

data class WeatherConditionResponse(
    val main: String,
) {
    companion object {
        private const val CLEAN_WEATHER = "clean"
        private const val PARTIAL_CLOUD_WEATHER = "partial cloud"
        private const val CLOUD_WEATHER = "cloud"
        private const val RAIN_WEATHER = "rain"
        private const val STORM_WEATHER = "storm"
        private const val SNOW_WEATHER = "snow"
    }

    fun toClimateCondition(): ClimateCondition =
        when (main.toLowerCase(Locale.getDefault())) {
            PARTIAL_CLOUD_WEATHER -> ClimateCondition.PartialClouds
            CLOUD_WEATHER -> ClimateCondition.Clouds
            RAIN_WEATHER -> ClimateCondition.Rain
            STORM_WEATHER -> ClimateCondition.Storm
            SNOW_WEATHER -> ClimateCondition.Snow
            else -> ClimateCondition.Clean
        }
}
