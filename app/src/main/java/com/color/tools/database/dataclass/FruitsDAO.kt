package com.color.tools.database.dataclass

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FruitsDAO {
    @Insert
    fun insertFruits(fruits: DataFruits)
    @Delete
    fun deleteFruits(fruits: DataFruits)
    @Update
    fun updateFruits(fruits: DataFruits)

    @Query("SELECT * FROM DataFruits")
    fun getAllFruits():List<DataFruits>

}