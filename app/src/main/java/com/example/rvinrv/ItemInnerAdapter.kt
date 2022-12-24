package com.example.rvinrv

import android.view.LayoutInflater
import android.view.Menu
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rvinrv.databinding.ItemInnerBinding

class ItemInnerAdapter : RecyclerView.Adapter<ItemInnerAdapter.ItemInnerViewHolder>() {
    inner class ItemInnerViewHolder(private val binding: ItemInnerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: String) {
            binding.apply {
                menuTvName.text = model
            }
        }

    }

    var models = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemInnerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_inner, parent, false)
        val binding = ItemInnerBinding.bind(view)
        return ItemInnerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemInnerViewHolder, position: Int) {
        holder.bind(models[position])
    }

}