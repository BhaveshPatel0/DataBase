package com.color.tools.database.dataclass

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface IndiaTeamDAO {

    @Insert
    fun insertTeam(dataIndiaTeam: DataIndiaTeam)
    @Delete
    fun deleteTeam(dataIndiaTeam: DataIndiaTeam)
    @Update
    fun updateTeam(dataIndiaTeam: DataIndiaTeam)

    @Query("SELECT * FROM DataIndiaTeam")
    fun getAllTeamMember():List<DataIndiaTeam>
}