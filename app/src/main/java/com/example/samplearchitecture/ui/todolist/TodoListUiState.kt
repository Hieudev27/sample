package com.example.samplearchitecture.ui.todolist

import com.example.samplearchitecture.data.model.Sample

data class TodoListUiState(
    val isLoading: Boolean = false,
    val items: List<Sample> = emptyList(),
)
