package com.example.todo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.db.Note
import kotlinx.android.synthetic.main.note_layout.view.*

class NotesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var notes : List<Note> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_layout,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return notes.size
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is NotesViewHolder -> {
                holder.bind(notes.get(position))
            }
        }
    }


    fun submitList(notesList: List<Note>){
        notes = notesList
    }
    class NotesViewHolder constructor(val noteView : View):RecyclerView.ViewHolder(noteView){
        val noteTitle = noteView.note_title
        val noteBody = noteView.note_body

        fun bind(noteItem:Note){
            noteTitle.setText(noteItem.title)
            noteBody.setText(noteItem.note)
        }
    }
}