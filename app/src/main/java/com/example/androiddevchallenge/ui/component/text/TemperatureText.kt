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
package com.example.androiddevchallenge.ui.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.domain.model.weather.Temperature
import com.example.androiddevchallenge.domain.model.weather.TemperatureUnit

@Composable
fun TemperatureText(
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.body1,
    temperature: Temperature,
    prefix: String? = null
) {
    Text(
        modifier = modifier,
        style = style,
        text = buildAnnotatedString {
            prefix?.run {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                    append(prefix)
                }
                append(" ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("%.1f".format(temperature.value))
            }
            append(temperature.unit.symbol)
        },
    )
}

@Preview
@Composable
fun TemperatureTextPreview() {
    val temp = Temperature(33.1f, TemperatureUnit.Celsius)
    TemperatureText(temperature = temp)
}
