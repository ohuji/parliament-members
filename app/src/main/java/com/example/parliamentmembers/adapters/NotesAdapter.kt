package com.example.parliamentmembers.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.parliamentmembers.R
import com.example.parliamentmembers.database.Note

/*
    Name: Juho Salomäki
    StudentID: 2110591
    Date: 3.3.2022
 */

//Adapter to NewNoteFragment.
class NotesAdapter(private val context: Context): ListAdapter<Note, NoteViewHolder>(NoteDiffCB()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.note_item_layout, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.n_text).text = getItem(position).noteText
    }
}

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

class NoteDiffCB: DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(
        oldItem: Note,
        newItem: Note
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Note,
        newItem: Note
    ): Boolean {
        return oldItem.noteText == newItem.noteText
    }

}