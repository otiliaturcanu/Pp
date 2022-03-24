package org.example

import java.io.File

class FileManager : Saveable, Deleteable {//ptfisierelanotite
    override fun saveNote(note: Note) {
        val fileName = "src/Notes/" + note.getTitle() +".txt"
        File(fileName).createNewFile()
        val file = File(fileName)

        file.printWriter().use { out ->
            out.println("Autor: " + note?.getContent()?.getAuthor())
            out.println("Data: " + note.getDate())
            out.println("Notita: " + note?.getContent()?.getText())
        }
    }

    override fun deleteNote(noteTitle: String) {
        val file = File("src/Notes/$noteTitle.txt")
        if(file != null){
            file.delete()
        }
    }
}