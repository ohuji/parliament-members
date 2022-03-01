package com.example.parliamentmembers.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import java.sql.Timestamp

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 16.2.2022
 */

//ParliamentMember entity.
@Entity
data class ParliamentMember (
    @PrimaryKey(autoGenerate = false)
    val personNumber: Int,
    val seatNumber: Int = 0,
    val last: String,
    val first: String,
    val party: String,
    val minister: Boolean = false,
    val picture: String = "",
    val twitter: String = "",
    val bornYear: Int = 0,
    val constituency: String = "",
    val karma: Int = 100
)

@Entity
data class Notes (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val personNumber: Int,
    val note: String,
    val timestamp: Timestamp
)

//Dao for handling mp_db queries.
@Dao
interface MpDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllOrUpdate(mps: List<ParliamentMember>)
    @Query("select distinct party from ParliamentMember")
    fun getParties(): LiveData<List<String>>
    @Query("select * from ParliamentMember")
    fun getMembers(): LiveData<List<ParliamentMember>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(mp: ParliamentMember)
}