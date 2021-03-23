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
package com.example.androiddevchallenge.ui.component.icon

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.model.weather.ClimateCondition
import com.example.androiddevchallenge.ui.theme.MyTheme

data class ClimateDataHolder(
    @DrawableRes val iconId: Int,
    @StringRes val descriptionId: Int
)

@Composable
fun ClimateIcon(modifier: Modifier = Modifier, condition: ClimateCondition) {
    val isLightTheme = MaterialTheme.colors.isLight
    val cleanIcon = if (isLightTheme) R.drawable.ic_sun else R.drawable.ic_moon
    val pcIcon = if (isLightTheme) R.drawable.ic_partial_cloud else R.drawable.ic_partial_cloud_moon
    val (iconId, descriptionId) = when (condition) {
        is ClimateCondition.PartialClouds -> ClimateDataHolder(pcIcon, R.string.partial_cloud)
        is ClimateCondition.Clouds -> ClimateDataHolder(R.drawable.ic_cloud, R.string.cloud)
        is ClimateCondition.Rain -> ClimateDataHolder(R.drawable.ic_rain, R.string.rain)
        is ClimateCondition.Storm -> ClimateDataHolder(R.drawable.ic_storm, R.string.storm)
        is ClimateCondition.Snow -> ClimateDataHolder(R.drawable.ic_snow, R.string.snow)
        else -> ClimateDataHolder(cleanIcon, R.string.clean)
    }
    Icon(
        modifier = modifier,
        painter = painterResource(id = iconId),
        contentDescription = stringResource(id = descriptionId)
    )
}

@Composable
@Preview
fun ClimateConditionPreview() {
    MyTheme {
        ClimateIcon(condition = ClimateCondition.Clean)
    }
}
