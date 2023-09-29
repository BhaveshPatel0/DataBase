package com.color.tools.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.color.tools.database.dataclass.DataFruits
import com.color.tools.database.dataclass.DataIndiaTeam
import com.color.tools.database.dataclass.FruitsDAO
import com.color.tools.database.dataclass.IndiaTeamDAO
import com.color.tools.database.mobilephone.database.mobilebrandname.DataMobileBrandName
import com.color.tools.database.mobilephone.database.mobilebrandname.MobileBrandNameDAO
import com.color.tools.database.vehicle.database.favorite.DataFavorite
import com.color.tools.database.vehicle.database.favorite.FavoriteDao
import com.color.tools.database.vehicle.database.vehiclebrandname.DataVehicleBrandName
import com.color.tools.database.vehicle.database.vehiclebrandname.VehicleBrandNameDao
import com.color.tools.database.vehicle.database.vehiclename.DataVehicleName
import com.color.tools.database.vehicle.database.vehiclename.VehicleNameDao

@Database(
    entities = [DataFruits::class, DataIndiaTeam::class, DataMobileBrandName::class, DataVehicleBrandName::class, DataVehicleName::class, DataFavorite::class],
    version = 1
)
abstract class FruitsDataBase : RoomDatabase() {

    abstract fun FruitsDAO(): FruitsDAO
    abstract fun IndiaTeamDAO(): IndiaTeamDAO
    abstract fun VehicleBrandNameDao(): VehicleBrandNameDao
    abstract fun VehicleNameDao(): VehicleNameDao
    abstract fun FavoriteDao(): FavoriteDao
    abstract fun MobileBrandNameDAO(): MobileBrandNameDAO

}