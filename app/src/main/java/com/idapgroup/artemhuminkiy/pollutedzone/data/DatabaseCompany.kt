package com.idapgroup.artemhuminkiy.pollutedzone.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Company::class), version = 1)
public abstract class DatabaseCompany : RoomDatabase() {
    abstract fun companyDao(): CompanyDao

    companion object {
        private var instance: DatabaseCompany? = null


        fun getInstance(context: Context): DatabaseCompany {
            if (instance == null) {
                instance = Room.inMemoryDatabaseBuilder(context.applicationContext, DatabaseCompany::class.java).build()
            }
            return instance!!
        }

        fun destroyInstance() = { instance = null }
    }
}