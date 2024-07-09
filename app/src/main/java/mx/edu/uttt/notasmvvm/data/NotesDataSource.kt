package mx.edu.uttt.notasmvvm.data

import mx.edu.uttt.notasmvvm.model.Note
import java.time.LocalDateTime

class NotesDataSource {
    fun loadNote(): List<Note> {
        return listOf(
            Note(
                title = "Hola mundo",
                description = "Un ejemplo de un mensaje",
                entryDate = LocalDateTime.now()
            )
        )
    }
}