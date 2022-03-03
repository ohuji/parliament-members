package com.example.parliamentmembers.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.parliamentmembers.repository.MemberRepo
import kotlinx.coroutines.launch

/*
    Name: Juho Salomäki
    StudentID: 2110591
    Date: 3.3.2022
 */

class NewNoteViewModel(application: Application): AndroidViewModel(application) {

    fun addNote(personNumber: Int, noteText: String) {
        viewModelScope.launch {
            MemberRepo.addNote(personNumber, noteText)
        }
    }
}