package com.example.parliamentmembers.repository

import com.example.parliamentmembers.database.MpDB
import com.example.parliamentmembers.network.MemberApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 17.2.2022
 */


object MemberRepo {
    suspend fun refreshDB() {
        withContext(Dispatchers.IO) {
            val members = MemberApi.retrofitService.getMpList()
            MpDB.getInstance().mpDAO.insertAllOrUpdate(members)
        }
    }
}