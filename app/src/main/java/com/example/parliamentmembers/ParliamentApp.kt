package com.example.parliamentmembers

import android.app.Application
import android.content.Context

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 16.2.2022
 */

/*
    A singleton that holds application
    context for database initialization.
 */
class ParliamentApp: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        lateinit var appContext: Context
    }
}