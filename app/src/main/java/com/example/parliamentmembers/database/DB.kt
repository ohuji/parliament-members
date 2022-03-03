package com.example.parliamentmembers.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parliamentmembers.ParliamentApp


/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 16.2.2022
 */

//Database initialization.
@Database(entities = [ParliamentMember::class], version = 5, exportSchema = false)
abstract class MpDB: RoomDatabase() {
    abstract val mpDAO: MpDao
    companion object {
        @Volatile
        private var INSTANCE: MpDB? = null

        fun getInstance(context: Context = ParliamentApp.appContext): MpDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        MpDB::class.java,
                        "mp_db"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}