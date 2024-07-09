package mx.edu.uttt.notasmvvm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.HistoricalChange
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import mx.edu.uttt.notasmvvm.ui.theme.Color10
import mx.edu.uttt.notasmvvm.ui.theme.Purple40
import org.w3c.dom.Text

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteIputText(modifier: Modifier = Modifier,
                 text: String,
                 label:String,
                 maxLine: Int = 1,
                 onTextChange: (String) ->Unit,
                 onImeAction: ()-> Unit = {}
                 ){
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        maxLines= maxLine, label= { Text(text = label)},
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }), modifier = modifier)
}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick:()->Unit,
    enabled:Boolean=true
){
    Button(onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White),
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple40
        )
        ) {
        Text(text= text)
    }
}