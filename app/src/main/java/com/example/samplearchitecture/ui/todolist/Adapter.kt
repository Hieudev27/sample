package com.example.samplearchitecture.ui.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplearchitecture.data.model.Sample
import com.example.samplearchitecture.databinding.ItemSampleBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val samples = mutableListOf<Sample>()

    class ViewHolder(val binding: ItemSampleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSampleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = samples.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sample = samples[position]
        with(holder.binding) {
            tvName.text = sample.name
            tvDes.text = sample.description
        }
    }

    fun submitList(items: List<Sample>) {
        samples.clear()
        samples.addAll(items)
        notifyDataSetChanged()
    }
}