package com.example.parliamentmembers.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.parliamentmembers.R
import com.example.parliamentmembers.databinding.FragmentMemberBinding
import com.example.parliamentmembers.viewmodels.MemberViewModel
import com.example.parliamentmembers.viewmodels.MemberViewModelFactory
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

        val viewModelFactory = MemberViewModelFactory(args.personNumber)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MemberViewModel::class.java)

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

        viewModel.karma.observe(requireActivity()) { mp ->
            binding.karmaView.text = mp[0].karma.toString()

            binding.thumbUpBtn.setOnClickListener {
                val newKarma = mp[0].karma.plus(5)

                viewModel.insertOrUpdate(
                    mp[0].personNumber,
                    mp[0].seatNumber,
                    mp[0].last,
                    mp[0].first,
                    mp[0].party,
                    mp[0].minister,
                    mp[0].picture,
                    mp[0].twitter,
                    mp[0].bornYear,
                    mp[0].constituency,
                    newKarma
                )
            }

            binding.thumbDownBtn.setOnClickListener {
                val newKarma = mp[0].karma.minus(5)

                viewModel.insertOrUpdate(
                    mp[0].personNumber,
                    mp[0].seatNumber,
                    mp[0].last,
                    mp[0].first,
                    mp[0].party,
                    mp[0].minister,
                    mp[0].picture,
                    mp[0].twitter,
                    mp[0].bornYear,
                    mp[0].constituency,
                    newKarma
                )
            }
        }

        return binding.root
    }

}