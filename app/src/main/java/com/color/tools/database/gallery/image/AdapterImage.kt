package com.color.tools.database.gallery.image

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.color.tools.database.databinding.ItemRcvImageBinding

class AdapterImage(val reqContext: Context, val listOfImage: ArrayList<String>) :
    RecyclerView.Adapter<AdapterImage.HolderImage>() {

    class HolderImage(val binding: ItemRcvImageBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderImage {
        return HolderImage(ItemRcvImageBinding.inflate(LayoutInflater.from(reqContext)))
    }

    override fun getItemCount(): Int {
        return listOfImage.size
    }

    override fun onBindViewHolder(holder: HolderImage, position: Int) {

        Glide.with(reqContext).load(listOfImage[position]).into(holder.binding.ivImage)

        holder.binding.tvFolderName.text=listOfImage[position]
    }
}