package com.color.tools.database.dataclass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataIndiaTeam(
    @PrimaryKey(autoGenerate = true)
    var id: Long?=null,
    var name: String?=null,
    var age: Int?=null
)
