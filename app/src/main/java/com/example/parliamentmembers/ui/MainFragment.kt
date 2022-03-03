package com.example.parliamentmembers.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.parliamentmembers.R
import com.example.parliamentmembers.databinding.FragmentMainBinding
import com.squareup.picasso.Picasso

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 17.2.2022
 */

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main, container, false)

        Picasso.get().load("https://live.staticflickr.com/65535/51857994408_ec17a04309_h.jpg")
            .into(binding.parliamentImg)

        binding.startButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_mainFragment_to_partySearchFragment)
        }

        return binding.root
    }
}