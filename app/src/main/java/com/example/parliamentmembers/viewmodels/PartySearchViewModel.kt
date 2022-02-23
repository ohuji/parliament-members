package com.example.parliamentmembers.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.parliamentmembers.repository.MemberRepo

class PartySearchViewModel(application: Application): AndroidViewModel(application) {
    val dbParties = MemberRepo.parties
}