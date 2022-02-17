package com.example.parliamentmembers.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.parliamentmembers.R
import com.example.parliamentmembers.databinding.FragmentPartyMemberSearchBinding

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 17.2.2022
 */

class PartyMemberSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPartyMemberSearchBinding>(inflater,
            R.layout.fragment_main, container, false)

        return binding.root
    }

}