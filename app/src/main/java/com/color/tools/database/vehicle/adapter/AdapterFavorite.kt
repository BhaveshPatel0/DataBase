package com.color.tools.database.vehicle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.color.tools.database.R
import com.color.tools.database.vehicle.database.favorite.DataFavorite
import org.w3c.dom.Text

class AdapterFavorite(val reqContext: Context, val listOfFavorite: ArrayList<DataFavorite>) :
    RecyclerView.Adapter<AdapterFavorite.HolderFavorite>() {



    class HolderFavorite(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvVehicleBrandName:TextView=itemView.findViewById(R.id.tvVehicleBrandName)
        val tvVehicleName:TextView=itemView.findViewById(R.id.tvVehicleName)
        val ivUnFavorite:ImageView=itemView.findViewById(R.id.ivUnFavorite)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderFavorite {

        return HolderFavorite(
            LayoutInflater.from(reqContext).inflate(R.layout.item_rcv_favorite, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return listOfFavorite.size
    }

    override fun onBindViewHolder(holder: HolderFavorite, position: Int) {




    }
}