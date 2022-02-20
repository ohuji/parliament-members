package com.example.parliamentmembers.network

import com.example.parliamentmembers.database.ParliamentMember
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 20.2.2022
 */

private const val BASE_URL = "https://users.metropolia.fi/~peterh/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MemberService {
    @GET("mps.json")
    suspend fun getMpList(): List<ParliamentMember>
}

object MemberApi {
    val retrofitService: MemberService by lazy {
        retrofit.create(MemberService::class.java)
    }
}