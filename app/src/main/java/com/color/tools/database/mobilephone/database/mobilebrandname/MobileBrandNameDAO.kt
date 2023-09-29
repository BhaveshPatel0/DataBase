package com.color.tools.database.mobilephone.database.mobilebrandname

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MobileBrandNameDAO {

    @Insert
    fun insertMobileBrandName(dataMobileBrandName: DataMobileBrandName)

    @Query("select * from DataMobileBrandName")
    fun getAllData(): List<DataMobileBrandName>

    @Query("select mobileBrandName from DataMobileBrandName")
    fun getAllMobileBrandName(): List<String>

}