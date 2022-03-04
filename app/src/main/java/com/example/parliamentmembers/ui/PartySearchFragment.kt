package com.example.parliamentmembers.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parliamentmembers.R
import com.example.parliamentmembers.adapters.PartyListAdapter
import com.example.parliamentmembers.databinding.FragmentPartySearchBinding
import com.example.parliamentmembers.viewmodels.PartySearchViewModel

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 17.2.2022
 */

//Fragment for searching parties.
class PartySearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPartySearchBinding>(inflater,
            R.layout.fragment_party_search, container, false)

        val viewModel = ViewModelProvider(this).get(PartySearchViewModel::class.java)
        val adapter = PartyListAdapter(requireContext())

        binding.partyView.adapter = adapter
        binding.partyView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.dbParties.observe(requireActivity()) {
            adapter.submitList(it)
        }

        return binding.root
    }

}


