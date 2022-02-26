package com.example.parliamentmembers.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.parliamentmembers.R
import com.example.parliamentmembers.databinding.FragmentMemberBinding
import com.squareup.picasso.Picasso

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 17.2.2022
 */

class MemberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMemberBinding>(inflater,
            R.layout.fragment_member, container, false)

        val args = MemberFragmentArgs.fromBundle(requireArguments())

        val name = "${args.name} ${args.bornYear}-"
        val personNumber = "Person Number: ${args.personNumber}"
        val seatNumber = "Seat Number: ${args.seatNumber}"
        val minister = "Is a minister: ${args.minister}"
        val constituency = "Constituency: ${args.constituency}"

        binding.memberName.text = name
        binding.memberPn.text = personNumber
        binding.memberSn.text = seatNumber
        binding.memberMinister.text = minister
        binding.memberCons.text = constituency

        val iView = binding.memberImage

        Picasso.get().load("https://avoindata.eduskunta.fi/${args.pic}").fit().into(iView)

        return binding.root
    }

}