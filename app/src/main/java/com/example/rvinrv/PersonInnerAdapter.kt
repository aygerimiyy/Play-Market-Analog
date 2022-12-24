package com.example.rvinrv

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.rvinrv.databinding.ActivityMainBinding
import com.example.rvinrv.databinding.ItemPersonBinding
import com.google.android.material.snackbar.Snackbar

class PersonInnerAdapter: RecyclerView.Adapter<PersonInnerAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(val binding: ItemPersonBinding): ViewHolder(binding.root){
            fun bind(person: Add){
                binding.apply {
                    tvName.text = person.name
                    ivMain.setImageResource(person.image)
                    ivMain1.setImageResource(person.imageMidle)
                    tvDescription.text = person.description


                     root.setOnClickListener{
                         onInnerItemClick.invoke(person.num)
                     }
                }
            }


    }
    var  models = listOf<Add>()
        @SuppressLint("NotifyDataSetChanged")
        set(value){
            field = value
            notifyDataSetChanged()
        }


    override fun getItemCount(): Int = models.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        val binding = ItemPersonBinding.bind(view)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(models[position])
    }


    private var onInnerItemClick: (id: Int) -> Unit = {}
    fun setInnerItemClickListener(onInnerItemClick: (id: Int) -> Unit){
        this.onInnerItemClick = onInnerItemClick
    }


}