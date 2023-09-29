package com.color.tools.database.mobilephone.database.mobilebrandname

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataMobileBrandName(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val mobileBrandName:String
)
