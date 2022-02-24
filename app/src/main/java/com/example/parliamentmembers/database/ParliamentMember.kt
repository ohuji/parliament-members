package com.example.parliamentmembers.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

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
    val constituency: String = ""
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
}