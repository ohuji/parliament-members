package com.example.parliamentmembers.viewmodels

import androidx.lifecycle.*
import com.example.parliamentmembers.repository.MemberRepo
import kotlinx.coroutines.launch

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 1.2.2022
 */

class MemberViewModel(args: Int): ViewModel() {
    private val personNumber = args
    private val members = MemberRepo.members

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