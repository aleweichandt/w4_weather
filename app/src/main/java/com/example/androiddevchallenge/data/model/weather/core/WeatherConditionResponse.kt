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

data class WeatherConditionResponse(
    val id: Int
) {
    companion object {

        private val STORM_WEATHER_RANGE = 200..299
        private val DRIZZLE_WEATHER_RANGE = 300..399
        private val RAIN_WEATHER_RANGE = 500..599
        private val SNOW_WEATHER_RANGE = 600..699
        private val EVENTS_WEATHER_RANGE = 700..799
        private val CLEAR_WEATHER_CODE = 800..800
        private val PARTIAL_WEATHER_RANGE = 801..801
        private val CLOUD_WEATHER_RANGE = 802..804
    }

    fun toClimateCondition(): ClimateCondition =
        when {
            STORM_WEATHER_RANGE.contains(id) -> ClimateCondition.Storm
            DRIZZLE_WEATHER_RANGE.contains(id) -> ClimateCondition.Storm
            RAIN_WEATHER_RANGE.contains(id) -> ClimateCondition.Rain
            SNOW_WEATHER_RANGE.contains(id) -> ClimateCondition.Snow
            EVENTS_WEATHER_RANGE.contains(id) -> ClimateCondition.Clouds
            CLOUD_WEATHER_RANGE.contains(id) -> ClimateCondition.Clouds
            PARTIAL_WEATHER_RANGE.contains(id) -> ClimateCondition.PartialClouds
            CLEAR_WEATHER_CODE.contains(id) -> ClimateCondition.Clean
            else -> ClimateCondition.PartialClouds
        }
}
