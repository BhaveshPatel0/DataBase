package com.color.tools.database.mobilephone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.color.tools.database.databinding.ItemRcvMobileBinding

class AdapterMobile(val reqContext: Context, val listOfMobile: ArrayList<String>) :
    RecyclerView.Adapter<AdapterMobile.HolderMobile>() {

    class HolderMobile(val binding: ItemRcvMobileBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMobile {
        return HolderMobile(ItemRcvMobileBinding.inflate(LayoutInflater.from(reqContext)))
    }

    override fun getItemCount(): Int {
        return listOfMobile.size
    }

    override fun onBindViewHolder(holder: HolderMobile, position: Int) {

        holder.binding.tvMobileName.text=listOfMobile[position]

    }
}