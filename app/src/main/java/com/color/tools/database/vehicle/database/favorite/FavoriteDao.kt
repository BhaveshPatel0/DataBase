package com.color.tools.database.vehicle.database.favorite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Insert
    fun insertFavorite(dataFavorite: DataFavorite)

    @Delete
    fun deleteFavorite(dataFavorite: DataFavorite)

    @Query("SELECT * FROM datafavorite")
    fun getAllData():List<DataFavorite>

    @Query("SELECT Favorite from datafavorite")
    fun getAllFavoriteVehicleName():List<String>

    @Query("delete from DataFavorite where Favorite=:nameOfVehicle")
    fun deleteByName(nameOfVehicle:String)
}