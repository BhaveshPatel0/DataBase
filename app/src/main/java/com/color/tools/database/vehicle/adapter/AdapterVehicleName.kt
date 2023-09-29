package com.color.tools.database.vehicle.adapter

import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.color.tools.database.R
import com.color.tools.database.database.FruitsDataBase
import com.color.tools.database.databinding.ItemRcvVehicleNameBinding
import com.color.tools.database.vehicle.VehicleNameAct
import com.color.tools.database.vehicle.database.favorite.DataFavorite
import com.color.tools.database.vehicle.database.vehiclebrandname.DataVehicleBrandName

class AdapterVehicleName(
    val reqContext: Context,
    val listOfVehicleName: ArrayList<String>,
    //call Back
    val onBackClick: (brandName: String) -> Unit,

    val isNeedToShowFavorite: Boolean? = false, val isFavorite: Boolean
) :
    RecyclerView.Adapter<AdapterVehicleName.HolderVehicleName>() {

    private lateinit var dataBase: FruitsDataBase
    var listOfFavorite = mutableListOf<String>()

    init {
        dataBase =
            Room.databaseBuilder(reqContext, FruitsDataBase::class.java, "VehicleBrandNameDB")
                .build()

    }

    class HolderVehicleName(val binding: ItemRcvVehicleNameBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderVehicleName {
        return HolderVehicleName(
            ItemRcvVehicleNameBinding.inflate(LayoutInflater.from(reqContext))
        )
    }

    override fun getItemCount(): Int {

        return listOfVehicleName.size
    }

    override fun onBindViewHolder(holder: HolderVehicleName, position: Int) {

        holder.binding.tvVehicleBrandName.text = listOfVehicleName[position]
        Thread {
            listOfFavorite = dataBase.FavoriteDao().getAllFavoriteVehicleName().toMutableList()

            Log.d("TAG", "onBindViewHolder:$listOfFavorite ")

            if (listOfFavorite.contains(listOfVehicleName[position])) {
                holder.binding.ivFavorite.setImageResource(R.drawable.ic_favorite)
            } else {
                holder.binding.ivFavorite.setImageResource(R.drawable.ic_unfavorite)
            }
        }.start()


        if (isNeedToShowFavorite == true) {
            holder.binding.ivFavorite.visibility = View.VISIBLE
            holder.binding.ivVehicleName.visibility = View.GONE
        } else {
            holder.binding.ivVehicleName.visibility = View.VISIBLE
            holder.binding.ivFavorite.visibility = View.GONE
        }

        if (position % 2 == 0) {
            holder.binding.llParent.setBackgroundColor(
                ContextCompat.getColor(
                    reqContext,
                    R.color.white
                )
            )
        } else {
            holder.binding.llParent.setBackgroundColor(
                ContextCompat.getColor(
                    reqContext,
                    R.color.background
                )
            )
        }

        holder.binding.llParent.setOnClickListener {
            onBackClick.invoke(listOfVehicleName[position])
        }

        holder.binding.ivFavorite.setOnClickListener {

            Thread {
                listOfFavorite = dataBase.FavoriteDao().getAllFavoriteVehicleName().toMutableList()

                if (listOfFavorite.contains(listOfVehicleName[position])) {
                    dataBase.FavoriteDao().deleteByName(listOfVehicleName[position])
                    holder.binding.ivFavorite.setImageResource(R.drawable.ic_unfavorite)
                } else {
                    dataBase.FavoriteDao()
                        .insertFavorite(DataFavorite(0, listOfVehicleName[position]))
                    holder.binding.ivFavorite.setImageResource(R.drawable.ic_favorite)
                }
            }.start()
        }
    }
}