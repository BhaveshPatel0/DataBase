package com.color.tools.database.vehicle.database.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataFavorite(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val Favorite:String
)
