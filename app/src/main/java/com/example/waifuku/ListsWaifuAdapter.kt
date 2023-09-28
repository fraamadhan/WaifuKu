package com.example.waifuku

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.waifuku.databinding.ItemWaifuRowBinding


class ListsWaifuAdapter(private val listWaifu: ArrayList<Waifu>) : RecyclerView.Adapter<ListsWaifuAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback : OnItemClickCallback

    interface OnItemClickCallback{
        fun onItemClicked(data : Waifu)
    }

    class ListViewHolder(var binding : ItemWaifuRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemWaifuRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listWaifu.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, detail, photo) = listWaifu[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listWaifu[holder.adapterPosition])
        }
    }

    fun setOnItemClickCallback(onItemClickCallBack : OnItemClickCallback){
        this.onItemClickCallback =onItemClickCallBack
    }
}