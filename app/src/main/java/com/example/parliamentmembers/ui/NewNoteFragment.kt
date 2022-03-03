package com.example.parliamentmembers.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.parliamentmembers.R
import com.example.parliamentmembers.databinding.FragmentNewNoteBinding
import com.example.parliamentmembers.viewmodels.NewNoteViewModel

/*
    Name: Juho Salomäki
    StudentID: 2110591
    Date: 3.3.2022
 */

class NewNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNewNoteBinding>(inflater,
            R.layout.fragment_new_note, container, false)

        val viewModel = ViewModelProvider(this).get(NewNoteViewModel::class.java)

        binding.addNoteBtn.setOnClickListener {
            val args = NewNoteFragmentArgs.fromBundle(requireArguments())

            val text = binding.noteEditText.text.toString()

            viewModel.addNote(args.personNumber, text)

            Toast.makeText(requireContext(), "Note added", Toast.LENGTH_LONG).show()

            view?.findNavController()?.navigate(NewNoteFragmentDirections
                .actionNewNoteFragmentToMemberFragment(
                    args.personNumber,
                    args.seatNumber,
                    args.name,
                    args.minister,
                    args.pic,
                    args.bornYear,
                    args.constituency
                ))

        }

        return binding.root
    }

}