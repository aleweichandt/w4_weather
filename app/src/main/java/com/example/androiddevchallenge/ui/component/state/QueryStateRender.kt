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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.domain.model.query.QueryState
import java.io.Serializable

@Composable
fun <T : Serializable> QueryStateRender(
    modifier: Modifier = Modifier,
    state: QueryState<T> = QueryState.Ready,
    onReady: @Composable () -> Unit = {},
    onLoading: @Composable () -> Unit = {},
    onFailure: @Composable () -> Unit = {},
    onSuccess: @Composable (data: T) -> Unit = {},
) {
    Crossfade(
        modifier = modifier,
        targetState = state
    ) { nextState ->
        when (nextState) {
            is QueryState.Loading -> onLoading()
            is QueryState.Failure -> onFailure()
            is QueryState.Success -> onSuccess(nextState.data)
            else -> onReady()
        }
    }
}

@Preview
@Composable
fun QueryStateRenderReadyPreview() {
    val state = QueryState.Ready
    QueryStateRender(
        state = state,
        onLoading = { Text(text = "loading") },
        onFailure = { Text(text = "failure") },
        onSuccess = { Text(text = "success") },
        onReady = { Text(text = "ready") },
    )
}

@Preview
@Composable
fun QueryStateRenderLoadingPreview() {
    val state = QueryState.Loading
    QueryStateRender(
        state = state,
        onLoading = { Text(text = "loading") },
        onFailure = { Text(text = "failure") },
        onSuccess = { Text(text = "success") },
        onReady = { Text(text = "ready") },
    )
}

@Preview
@Composable
fun QueryStateRenderFailurePreview() {
    val state = QueryState.Failure
    QueryStateRender(
        state = state,
        onLoading = { Text(text = "loading") },
        onFailure = { Text(text = "failure") },
        onSuccess = { Text(text = "success") },
        onReady = { Text(text = "ready") },
    )
}

@Preview
@Composable
fun QueryStateRenderSuccessPreview() {
    val state = QueryState.Success("!")
    QueryStateRender(
        state = state,
        onLoading = { Text(text = "loading") },
        onFailure = { Text(text = "failure") },
        onSuccess = { Text(text = "success$it") },
        onReady = { Text(text = "ready") },
    )
}
