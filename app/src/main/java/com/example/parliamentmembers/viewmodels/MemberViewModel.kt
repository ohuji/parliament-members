package com.example.parliamentmembers.viewmodels

import androidx.lifecycle.*
import com.example.parliamentmembers.repository.MemberRepo
import kotlinx.coroutines.launch

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 1.2.2022
 */

//ViewModel for MemberFragment.
class MemberViewModel(args: Int): ViewModel() {
    //Get members, notes and arguments.
    private val personNumber = args
    private val members = MemberRepo.members
    private val notes = MemberRepo.notes

    /*
        Filter notes and members by personNumber.
     */
    val note = Transformations.map(notes) { list ->
        list.filter {
            it.personNumber == personNumber
        }
    }

    val karma = Transformations.map(members) { list ->
        list.filter {
            it.personNumber == personNumber
        }
    }

    fun insertOrUpdate(personNumber: Int,
                       seatNumber: Int,
                       last: String,
                       first: String,
                       party: String,
                       minister: Boolean,
                       picture: String,
                       twitter: String,
                       bornYear: Int,
                       constituency: String,
                       karma: Int) {
        viewModelScope.launch {
            MemberRepo.insertOrUpdate(personNumber,
                seatNumber,
                last,
                first,
                party,
                minister,
                picture,
                twitter,
                bornYear,
                constituency,
                karma)
        }

    }
}

class MemberViewModelFactory(private val personNumber: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemberViewModel::class.java)) {
            return MemberViewModel(personNumber) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }

}