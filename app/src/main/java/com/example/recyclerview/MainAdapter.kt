package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemBinding

class MainAdapter(val data : ArrayList<Data>, private val onClick:(data : Data, position : Int)->Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(ItemBinding.bind(v))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvNum.text = data[position].itemNumber
        holder.binding.tvMain.text = data[position].itemText
    }

    override fun getItemCount(): Int = data.size

}