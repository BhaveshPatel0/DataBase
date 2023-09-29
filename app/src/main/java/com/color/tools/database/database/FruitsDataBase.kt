package com.color.tools.database.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.color.tools.database.dataclass.DataFruits
import com.color.tools.database.dataclass.DataIndiaTeam
import com.color.tools.database.dataclass.FruitsDAO
import com.color.tools.database.dataclass.IndiaTeamDAO

@Database(entities = [DataFruits::class,DataIndiaTeam::class], version = 1)
abstract class FruitsDataBase:RoomDatabase() {

    abstract fun FruitsDAO():FruitsDAO
    abstract fun IndiaTeamDAO():IndiaTeamDAO
}