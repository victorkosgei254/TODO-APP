package com.example.todo.ui


import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.todo.R
import com.example.todo.db.Note
import com.example.todo.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*

/**
 * A simple [Fragment] subclass.
 */
class AddNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        NoteDatabase(activity!!).getNoteDao().
        setClickListeners()
    }

    private fun setClickListeners() {
        button_save.setOnClickListener{
            val noteTitle = edit_text_title.text.toString().trim()
            val noteBody = edit_text_note.text.toString().trim()
            if (noteTitle.isEmpty()){
                edit_text_title.error="Title is required"
                edit_text_title.requestFocus()
                return@setOnClickListener
            }

            val note = Note(title = noteTitle,note = noteBody)
            saveNote(note)
        }
    }

    private fun saveNote(note: Note){
        class SaveNote:AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg params: Void?): Void? {
                NoteDatabase(activity!!).getNoteDao().addNote(note)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(activity,"Note Has been Saved",Toast.LENGTH_SHORT).show()
            }

        }

        SaveNote().execute()
    }

}
