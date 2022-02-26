package com.example.parliamentmembers.viewmodels

import androidx.lifecycle.*
import com.example.parliamentmembers.database.MpDB

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 25.2.2022
 */

class PartyMemberSearchViewModel(args: String): ViewModel() {
    private val party = args
    private val members = MpDB.getInstance().mpDAO.getMembers()

    val filteredMembers = Transformations.map(members) { list ->
        list.filter {
            "PartyMemberSearchFragmentArgs{party=${it.party}}" == party
        }
    }

}

class PartyMemberSearchViewModelFactory(private val party: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PartyMemberSearchViewModel::class.java)) {
            return PartyMemberSearchViewModel(party) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }

}