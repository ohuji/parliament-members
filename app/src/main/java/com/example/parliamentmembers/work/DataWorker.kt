package com.example.parliamentmembers.work

import android.content.Context
import androidx.work.*
import com.example.parliamentmembers.repository.MemberRepo
import retrofit2.HttpException

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 20.2.2022
 */

class DataWorker(appContext: Context, params: WorkerParameters):
        CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "com.example.parliamentmembers.work.DataWorker"
    }

    override suspend fun doWork(): Result {
        try {
            MemberRepo.refreshDB()
        } catch(e: HttpException) {
            return Result.retry()
        }

        return Result.success()
    }

}