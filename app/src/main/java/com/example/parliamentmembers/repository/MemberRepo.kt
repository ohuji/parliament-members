package com.example.parliamentmembers.repository

import com.example.parliamentmembers.database.MpDB
import com.example.parliamentmembers.database.Note
import com.example.parliamentmembers.database.ParliamentMember
import com.example.parliamentmembers.network.MemberApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 17.2.2022
 */

//Repository
object MemberRepo {
    //Get data from database.
    val parties = MpDB.getInstance().mpDAO.getParties()
    val members = MpDB.getInstance().mpDAO.getMembers()
    val notes = MpDB.getInstance().mpDAO.getNotes()


    //Retrieving fetched data and insert it to database.
    suspend fun refreshDB() {
        withContext(Dispatchers.IO) {
            val members = MemberApi.retrofitService.getMpList()
            MpDB.getInstance().mpDAO.insertAllOrUpdate(members)
        }
    }

    //Insert note to database
    suspend fun addNote(
        personNumber: Int,
        noteText: String
    ) {
        MpDB.getInstance()
            .mpDAO
            .addNote(Note(
                    personNumber,
                    noteText,
                    timestamp = System.currentTimeMillis())
            )
    }

    //Insert ParliamentMember to database.
    suspend fun insertOrUpdate(
        personNumber: Int,
        seatNumber: Int,
        last: String,
        first: String,
        party: String,
        minister: Boolean,
        picture: String,
        twitter: String,
        bornYear: Int,
        constituency: String,
        karma: Int
    ) {
        MpDB.getInstance()
            .mpDAO
            .insertOrUpdate(ParliamentMember(
                personNumber,
                seatNumber,
                last,
                first,
                party,
                minister,
                picture,
                twitter,
                bornYear,
                constituency,
                karma))
    }


}