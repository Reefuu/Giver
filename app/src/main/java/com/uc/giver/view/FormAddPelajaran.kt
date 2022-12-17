package com.uc.giver.view

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.uc.giver.model.PelajaranState
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.viewModel.PelajaranViewModel
import dagger.hilt.android.AndroidEntryPoint

//form addPelajaran{
//    @csrf
//    method="GET",
//    <label>Nama Pelajaran</label>,
//    <br>
//            <input type="text"></input>
//    <label>Kelas</label>,
//    <br>
//            <input type="text"</input>
//    <label>Gambar</label>,
//    <br>
//            <input type="file"></input>
//}

@AndroidEntryPoint
class FormAddPelajaran : ComponentActivity() {


    private lateinit var pljrnViewModel: PelajaranViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(onClick = { pljrnViewModel.addPljrn() }) {
                        Icon(Icons.Filled.Add, null)
                    }
                },
                // Defaults to FabPosition.End
                floatingActionButtonPosition = FabPosition.End,
                content = {
                    // Screen content
                    GiverTheme {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = SoftWhite,
                        ) {
                            Column {
                                formAddPljrn()
//                            PljrnList(pljrn = response)
//                            FAB()
                            }
                        }
                    }
                }
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formAddPljrn() {

    val mContext = LocalContext.current as? Activity

    var state by mutableStateOf(PelajaranState())

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "ADD PELAJARAN",
//            style = TextStyle(fontSize = TextUnit(16))
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(value = state.nama_pelajaran,
            onValueChange = {state = state.copy(nama_pelajaran = it)},
            label ={ Text(text = "Nama Pelajaran")},
        )


        val kelasOptions = listOf("7", "8", "9")
        val (selectedOption, onOptionSelected) = remember {
            mutableStateOf(kelasOptions[0])
        }

        Column(Modifier.selectableGroup()) {
            kelasOptions.forEach{ text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = (text == selectedOption), onClick = null)
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 16.dp)
                        )
                }
            }
        }

    }
}