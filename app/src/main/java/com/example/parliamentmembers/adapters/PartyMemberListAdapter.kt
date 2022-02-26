package com.example.parliamentmembers.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.parliamentmembers.R
import com.example.parliamentmembers.database.ParliamentMember
import com.example.parliamentmembers.ui.MemberFragment
import com.example.parliamentmembers.ui.PartyMemberSearchFragmentDirections
import com.squareup.picasso.Picasso

/*
    Name: Juho Salomäki
    Student ID: 2110591
    Date: 25.2.2022
 */

class PartyMemberListAdapter(private val context: Context): ListAdapter<ParliamentMember, PartyMemberViewHolder>(PartyMemberDiffCB()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyMemberViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.mp_item_layout, parent, false)
        return PartyMemberViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartyMemberViewHolder, position: Int) {
        val name = "${getItem(position).first} ${getItem(position).last}"

        holder.itemView.findViewById<TextView>(R.id.mpl_text).text = name

        val iView = holder.itemView.findViewById<ImageView>(R.id.image_mpl)
        Picasso.get().load("https://avoindata.eduskunta.fi/${getItem(position).picture}").into(iView)

        holder.itemView.setOnClickListener {
            val args = Bundle()

            val personNumber = getItem(position).personNumber
            val seatNumber = getItem(position).seatNumber
            val minister = getItem(position).minister
            val pic = getItem(position).picture
            val bornYear = getItem(position).bornYear
            val constituency = getItem(position).constituency

            val frag = MemberFragment()

            frag.arguments = args

            it?.findNavController()?.navigate(PartyMemberSearchFragmentDirections
                .actionPartyMemberSearchFragmentToMemberFragment(
                    personNumber,
                    seatNumber,
                    name,
                    minister,
                    pic,
                    bornYear,
                    constituency))
        }
    }
}

class PartyMemberViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

class PartyMemberDiffCB: DiffUtil.ItemCallback<ParliamentMember>() {
    override fun areItemsTheSame(
        oldItem: ParliamentMember,
        newItem: ParliamentMember
    ): Boolean {
        return oldItem.personNumber == newItem.personNumber &&
                oldItem.seatNumber == newItem.seatNumber
    }

    override fun areContentsTheSame(
        oldItem: ParliamentMember,
        newItem: ParliamentMember
    ): Boolean {
        return oldItem.personNumber == newItem.personNumber &&
                oldItem.seatNumber == newItem.seatNumber &&
                oldItem.last == newItem.last &&
                oldItem.first == newItem.first &&
                oldItem.party == newItem.party &&
                oldItem.minister == newItem.minister &&
                oldItem.picture == newItem.picture &&
                oldItem.twitter == newItem.twitter &&
                oldItem.bornYear == newItem.bornYear &&
                oldItem.constituency == newItem.constituency
    }

}