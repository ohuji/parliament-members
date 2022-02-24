package com.example.parliamentmembers.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.parliamentmembers.R
import com.example.parliamentmembers.ui.PartyMemberSearchFragment
import com.example.parliamentmembers.ui.PartySearchFragmentDirections

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 24.2.2022
 */

class PartyListAdapter(private val context: Context): ListAdapter<String, PartyViewHolder>(PartyDiffCB()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.party_item_layout, parent, false)
        return PartyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.p_name).text = getItem(position)
        holder.itemView.setOnClickListener {
            val args = Bundle()
            val party = getItem(position)

            val frag = PartyMemberSearchFragment()

            frag.arguments = args

            it?.findNavController()?.navigate(PartySearchFragmentDirections
                .actionPartySearchFragmentToPartyMemberSearchFragment(party))

        }
    }
}

class PartyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

class PartyDiffCB: DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem == newItem
    }

}