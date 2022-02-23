package com.example.parliamentmembers.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.parliamentmembers.R

class PartyListAdapter(private val context: Context): ListAdapter<String, PartyViewHolder>(PartyDiffCB()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.party_item_layout, parent, false)
        return PartyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.p_name).text = getItem(position)
        holder.itemView.setOnClickListener {
            Log.d("moromoro", getItem(position))
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