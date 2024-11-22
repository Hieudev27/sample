package com.example.samplearchitecture.ui.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplearchitecture.data.model.Sample
import com.example.samplearchitecture.data.repo.sample.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
) : ViewModel() {
    private val uiState = MutableStateFlow(TodoListUiState())
    val state = uiState.asStateFlow()

    init {
        viewModelScope.launch {
            sampleRepository.getAllData().collect { items ->
                uiState.update { it.copy(items = items) }
            }
        }
    }
    fun addSample() {
        viewModelScope.launch {
            sampleRepository.insert(Sample(name = "name", description = "description"))
        }
    }
}