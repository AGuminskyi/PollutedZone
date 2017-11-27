package com.idapgroup.artemhuminkiy.pollutedzone.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface CompanyDao {

    @Insert(onConflict = REPLACE)
    fun insert(company: Company)

    @Query("DELETE FROM company WHERE id = :input_id")
    fun deleteById(input_id: Int)

    @Query("DELETE FROM company")
    fun deleteAll()

    @Query("SELECT * FROM company")
    fun companies() : List<Company>

    @Query("SELECT * FROM company WHERE id = :input_id")
    fun id(input_id : String) : Company

    @Query("SELECT * FROM company WHERE longitude = :input_longitude" +
            " and latitude = :input_latitude")
    fun getByCoordinates(input_longitude: Double, input_latitude : Double) : Company

}