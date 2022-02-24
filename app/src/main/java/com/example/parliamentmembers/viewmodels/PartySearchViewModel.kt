package com.example.parliamentmembers.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.parliamentmembers.repository.MemberRepo

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 24.2.2022
 */

class PartySearchViewModel(application: Application): AndroidViewModel(application) {
    val dbParties = MemberRepo.parties
}