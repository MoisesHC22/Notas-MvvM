package mx.edu.uttt.notasmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import mx.edu.uttt.notasmvvm.model.Note
import mx.edu.uttt.notasmvvm.screen.NoteScreen
import mx.edu.uttt.notasmvvm.ui.theme.Color10
import mx.edu.uttt.notasmvvm.ui.theme.NotasMvvMTheme
import mx.edu.uttt.notasmvvm.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotasMvvMTheme {
                NotasMvvMTheme {

                    Surface (
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.onPrimary
                        ){
                        val systemUIController = rememberSystemUiController()
                        SideEffect {
                            systemUIController.setStatusBarColor(
                                color = Purple40,
                            )
                        }
                        val notes = remember { mutableStateListOf<Note>() }

                        NoteScreen(
                            notas = notes,
                            onRemoveNote = {
                                note -> notes.remove(note)
                            },
                            onAddNote = {
                                note -> notes.add(note)
                            })

                        }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotasMvvMTheme {
        NoteScreen(notas = emptyList(), onRemoveNote = {}, onAddNote ={} )

        }
    }