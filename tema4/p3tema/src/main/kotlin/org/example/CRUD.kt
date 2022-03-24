package org.example

interface CRUD {//metode peste notite
    fun listNotes()
    fun showNote(note: String)
    fun createNote()
    fun deleteNote(note: String)
}