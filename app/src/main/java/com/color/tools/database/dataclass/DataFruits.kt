package com.color.tools.database.dataclass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataFruits(
    @PrimaryKey(autoGenerate = true)
    var fruitsID: Long? = null,
    var name: String? = "",
    var detail: String? = ""
)
