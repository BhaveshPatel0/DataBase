package com.color.tools.database.vehicle.database.vehiclename

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataVehicleName(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val vehicleName:String,
    val brandName:String
)
