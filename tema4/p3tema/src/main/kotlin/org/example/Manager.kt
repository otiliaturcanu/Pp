package org.example

import java.io.File

class Manager : CRUD {//pt notite


    override fun listNotes() {

        File("src/Notes").walk()
            .filter { it.isFile }
            .forEach { print(it.name +"; ")}

        println()
    }

    override fun showNote(noteTitle: String) {
        var file = File("src/Notes/$noteTitle.txt")
        if(file.exists()){
            file.forEachLine { println(it) }
        }
        else{
            println("Nu exista o notita cu acest titlu!")
        }
    }

    override fun createNote() {
        var note = Note()
        println("Adaugati un titlu pentru notita:\n")
        var title = readLine()
        if (title != null) {
            note.setTitle(title)
        }
        println()
        var content = Content()
        println("Adaugati un nume de autor:\n")
        var author = readLine()
        if (author != null) {
            content.setAuthor(author)
        }
        println()
        println("Adaugati notita:\n")
        var text = readLine()
        if (text != null) {
            content.setText(text)
        }
        note.setContent(content)
        var fileManager = FileManager()
        fileManager.saveNote(note)
    }

    override fun deleteNote(noteTitle: String) {
        var file = File("src/Notes/$noteTitle.txt")
        if(file.exists()){
            var fileManager = FileManager()
            fileManager.deleteNote(noteTitle)
            println("Notita a fost stearsa!")
        }
        else{
            println("Nu exista notita data!")
        }
    }

}