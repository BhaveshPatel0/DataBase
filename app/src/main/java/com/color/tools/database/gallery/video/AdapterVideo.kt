package com.color.tools.database.gallery.video

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.color.tools.database.databinding.ItemRcvVideoBinding

class AdapterVideo(val reqContext: Context.val listOfVideo:ArrayList<String>) : RecyclerView.Adapter<AdapterVideo.HolderVideo>() {

    class HolderVideo(val binding: ItemRcvVideoBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderVideo {
        return HolderVideo(ItemRcvVideoBinding.inflate(LayoutInflater.from(reqContext)))
    }

    override fun getItemCount(): Int {
        return listOfVideo.size

    }

    override fun onBindViewHolder(holder: HolderVideo, position: Int) {

    }
}