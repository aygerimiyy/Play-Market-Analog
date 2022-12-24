package com.example.rvinrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.rvinrv.databinding.ItemPersonBinding
import com.example.rvinrv.databinding.ItemRvBinding

class RVAdapter: RecyclerView.Adapter<RVAdapter.RVViewHolder>() {
    inner class RVViewHolder(private val binding: ItemRvBinding) : ViewHolder(binding.root) {
        fun bind(rvItem: Item) {
            val persInnerAdapter = PersonInnerAdapter()
            binding.innerRecycleView.adapter = persInnerAdapter

         persInnerAdapter.setInnerItemClickListener {id ->
             onInnerItemClick.invoke(id)
         }



            persInnerAdapter.models = rvItem.list
        }
    }

    var models = listOf<Item>()
        set(value){
            field = value
        }

    override fun getItemCount(): Int = models.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        val binding = ItemRvBinding.bind(view)
        return RVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.bind(models[position])
    }

    private var onInnerItemClick: (id: Int) -> Unit = {}
    fun setInnerItemClickListener(onInnerItemClick: (id: Int) -> Unit){
        this.onInnerItemClick = onInnerItemClick
    }

}