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
import com.example.parliamentmembers.adapters.PartyMemberListAdapter
import com.example.parliamentmembers.databinding.FragmentPartyMemberSearchBinding
import com.example.parliamentmembers.viewmodels.PartyMemberSearchViewModel
import com.example.parliamentmembers.viewmodels.PartyMemberSearchViewModelFactory

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 17.2.2022
 */

//Fragment for searching party's members.
class PartyMemberSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPartyMemberSearchBinding>(inflater,
            R.layout.fragment_party_member_search, container, false)

        val args = PartyMemberSearchFragmentArgs.fromBundle(requireArguments())

        val viewModelFactory = PartyMemberSearchViewModelFactory(args.toString())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(PartyMemberSearchViewModel::class.java)

        val adapter = PartyMemberListAdapter(requireContext())

        binding.partyMemberView.adapter = adapter
        binding.partyMemberView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.filteredMembers.observe(requireActivity()) {
            adapter.submitList(it)
        }

        return binding.root
    }

}