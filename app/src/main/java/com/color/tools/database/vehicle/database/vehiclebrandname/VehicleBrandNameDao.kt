package com.color.tools.database.vehicle.database.vehiclebrandname

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.color.tools.database.vehicle.database.vehiclebrandname.DataVehicleBrandName

@Dao
interface VehicleBrandNameDao {

    @Insert
    fun insertVehicleBrandName(dataVehicleBrandName: DataVehicleBrandName)

    @Query("SELECT * FROM datavehiclebrandname")
    fun getAllVehicleBrandName():List<DataVehicleBrandName>

    @Query("SELECT vehicleName FROM datavehiclebrandname")
    fun getAllVehicleBrand():List<String>


}