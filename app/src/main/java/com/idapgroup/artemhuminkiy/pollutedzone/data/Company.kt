package com.idapgroup.artemhuminkiy.pollutedzone.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "company")
public class Company {

    constructor(@NonNull id: String, @NonNull name : String,  @NonNull address : String){
        this.id = id
        this.name = name
        this.address = address
    }

//    constructor(@NonNull id : String, @NonNull name : String, @NonNull longitude : Double, @NonNull latitude : Double)  {
//        this.id = id
//        this.name = name
//        this.longitude = longitude
//        this.latitude = latitude
//    }

    @NonNull
    @ColumnInfo(name = "id")
    @PrimaryKey lateinit var id : String

    @NonNull
    @ColumnInfo(name = "name")
    lateinit var name : String

    @ColumnInfo(name = "address")
    lateinit var address : String

    @ColumnInfo(name = "longitude")
    var longitude : Double = 0.0

    @ColumnInfo(name = "latitude")
    var latitude : Double = 0.0

    @ColumnInfo(name = "poluttionZone")
    var poluttionZone : Double = 0.0
}