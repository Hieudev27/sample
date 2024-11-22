package com.example.samplearchitecture.ui.todolist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.samplearchitecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TodoListActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<TodoListViewModel>()
    private val adapter by lazy { Adapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        handleObservers()
        handleClicks()
    }

    private fun handleClicks() {
        binding.fab.setOnClickListener {
            viewModel.addSample()
        }
    }

    private fun handleObservers() {
        viewModel.state
            .map { it.items }
            .flowWithLifecycle(lifecycle)
            .distinctUntilChanged()
            .onEach {
                adapter.submitList(it)
            }
            .launchIn(lifecycleScope)
    }

    private fun initViews() {
        binding.recyclerView.adapter = adapter
    }
}