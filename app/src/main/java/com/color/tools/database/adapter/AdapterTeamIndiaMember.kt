package com.color.tools.database.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.color.tools.database.R
import com.color.tools.database.dataclass.DataIndiaTeam

class AdapterTeamIndiaMember(val reqContext: Context, val listOfTeamDetail:ArrayList<DataIndiaTeam>) :
    RecyclerView.Adapter<AdapterTeamIndiaMember.HolderTeamIndiaMember>() {

    class HolderTeamIndiaMember(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPlayerID:TextView=itemView.findViewById(R.id.tvPlayerID)
        val tvPlayerName:TextView=itemView.findViewById(R.id.tvPlayerName)
        val tvPlayerAge:TextView=itemView.findViewById(R.id.tvPlayerAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HolderTeamIndiaMember(LayoutInflater.from(reqContext).inflate(R.layout.item_india_team,parent,false))

    override fun getItemCount(): Int {
        return listOfTeamDetail.size
    }

    override fun onBindViewHolder(holder: HolderTeamIndiaMember, position: Int) {
        holder.tvPlayerID.text=listOfTeamDetail[position].id.toString()
        holder.tvPlayerName.text=listOfTeamDetail[position].name
        holder.tvPlayerAge.text=listOfTeamDetail[position].age.toString()

    }

}