package com.color.tools.database.vehicle.database.vehiclebrandname

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataVehicleBrandName(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val vehicleName:String
)
