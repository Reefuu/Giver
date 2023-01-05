package com.uc.giver.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.view.widgets.FloatingAppBtn
import com.uc.giver.viewModel.BukuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormAddBuku : ComponentActivity() {



    private lateinit var bukuViewModel: BukuViewModel



    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var pelajaran_id: String = intent.getIntExtra("pelajaran_id", 0).toString()

            bukuViewModel =
                ViewModelProvider(this).get(BukuViewModel::class.java)
            Scaffold(
                floatingActionButton = {
                    addBukuFAB(pelajaranInt = pelajaran_id.toInt())
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

                                Column(
                                    modifier = Modifier.padding(20.dp),
                                    verticalArrangement = Arrangement.Center,
                                ) {

                                    Text(
                                        text = "ADD BUKU",
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        fontWeight = FontWeight.SemiBold,
                                    )

                                    Spacer(modifier = Modifier.height(15.dp))

                                    TextField(
                                        value = bukuViewModel.state.nama_buku,
                                        onValueChange = {
                                            bukuViewModel.state =
                                                bukuViewModel.state.copy(nama_buku = it)
                                        },
                                        label = { Text(text = "Nama Buku") },
                                        modifier = Modifier.fillMaxWidth()
                                    )

                                    Spacer(modifier = Modifier.height(15.dp))

                                    Text(text = "Pelajaran ID : $pelajaran_id")
                                    bukuViewModel.state = bukuViewModel.state.copy(pelajaran_id = pelajaran_id.toInt(), imageCover = "imageCover", imageBanner = "imageBanner")
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
fun addBukuFAB(pelajaranInt: Int) {
    FloatingAppBtn(pelajaranInt = pelajaranInt, 0, 0, 0)
}