package com.example.todo.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.todo.R
import com.example.todo.db.Note
import com.example.todo.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {

    private lateinit var notesAdapter: NotesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startListeningToClickEvents()
        initRecylerView()


    }

    private fun startListeningToClickEvents() {
        button_add.setOnClickListener{
            val action = HomeFragmentDirections.actionAddNote()
            Navigation.findNavController(it).navigate(action)
        }
    }




    private fun initRecylerView(){
        launch {
            context?.let {
                val note = NoteDatabase(it).getNoteDao().getAllNotes()
                notesAdapter.submitList(note)

            }

        }
        recycler_view_notes.apply {
            layoutManager=LinearLayoutManager(activity)
            notesAdapter = NotesAdapter()
            adapter = notesAdapter



        }



    }


}
