package mx.edu.uttt.notasmvvm.data

import mx.edu.uttt.notasmvvm.model.Note


class NotesDataSource {
    fun loadNote(): List<Note> {
        return listOf(
            Note(title = "Hola mundo", description = "Un ejemplo de un mensaje"),
            Note(title = "como estas", description = "Un ejemplo de un mensaje")
        )
    }
}