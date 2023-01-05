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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.uc.giver.model.PelajaranState
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.view.widgets.FloatingAppBtn
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
            pljrnViewModel =
                ViewModelProvider(this).get(com.uc.giver.viewModel.PelajaranViewModel::class.java)
            Scaffold(
                floatingActionButton = {
                    addFAB()
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
//                                formAddPljrn()

                                Column(
                                    modifier = Modifier.padding(20.dp),
                                    verticalArrangement = Arrangement.Center,
                                ) {

                                    Text(
                                        text = "ADD PELAJARAN",
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        fontWeight = FontWeight.SemiBold,
                                    )

                                    Spacer(modifier = Modifier.height(15.dp))

                                    TextField(
                                        value = pljrnViewModel.state.nama_pelajaran,
                                        onValueChange = {
                                            pljrnViewModel.state =
                                                pljrnViewModel.state.copy(nama_pelajaran = it)
                                        },
                                        label = { Text(text = "Nama Pelajaran") },
                                        modifier = Modifier.fillMaxWidth()
                                    )

                                    val kelasOptions = listOf(7, 8, 9)

                                    Text(
                                        text = "Kelas",
                                        modifier = Modifier.padding(top = 16.dp),
                                        fontWeight = FontWeight.SemiBold,
                                        )


                                    Row(Modifier.selectableGroup()) {
                                        kelasOptions.forEach { text ->
                                            Row(
                                                Modifier
                                                    .width(100.dp)
                                                    .height(56.dp)
                                                    .selectable(
                                                        selected = (pljrnViewModel.state.kelas == text),
                                                        onClick = {
                                                            pljrnViewModel.state =
                                                                pljrnViewModel.state.copy(kelas = text)
                                                        },
                                                        role = Role.RadioButton
                                                    )
                                                    .wrapContentSize(Alignment.Center)
                                                    .padding(end = 16.dp),
                                            ) {
                                                RadioButton(
                                                    selected = (pljrnViewModel.state.kelas == text),
                                                    onClick = {
                                                        pljrnViewModel.state =
                                                            pljrnViewModel.state.copy(kelas = text)
                                                    },
                                                    modifier = Modifier.width(40.dp)
                                                )
                                                Text(
                                                    text = text.toString(),
                                                    modifier = Modifier
                                                        .width(60.dp)
                                                        .align(Alignment.CenterVertically),
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun addFAB() {
    FloatingAppBtn(0, 0, 0)
}
