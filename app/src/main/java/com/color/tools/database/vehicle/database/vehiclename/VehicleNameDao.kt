package com.color.tools.database.vehicle.database.vehiclename

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface VehicleNameDao {

    @Insert
    fun insertVehicleName(dataVehicleName: DataVehicleName)

    @Query("SELECT * FROM datavehiclename")
    fun getAllVehicleName():List<DataVehicleName>

    @Query("SELECT vehicleName FROM datavehiclename")
    fun getALLVehicleName():List<String>

    @Query("SELECT vehicleName FROM datavehiclename WHERE brandName=:brandName")
    fun getVehicleNameByBrandName(brandName:String):List<String>

    @Query("select * from datavehiclename where brandName=:tata")
    fun abc(tata:String):List<DataVehicleName>

}