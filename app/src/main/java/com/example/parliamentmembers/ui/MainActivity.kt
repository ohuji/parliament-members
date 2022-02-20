package com.example.parliamentmembers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.parliamentmembers.R
import com.example.parliamentmembers.work.DataWorker
import java.util.concurrent.TimeUnit

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 16.2.2022
 */

//Main activity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val periodicRequest =
            PeriodicWorkRequestBuilder<DataWorker>(1, TimeUnit.HOURS)
                .setConstraints(myConstraints)
                .build()

        WorkManager.getInstance(this.applicationContext).enqueue(periodicRequest)

        val navController = this.findNavController(R.id.navHostFragment)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
        return navController.navigateUp()
    }
}