package com.uc.giver.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.view.widgets.FloatingAppBtn
import com.uc.giver.viewModel.BabViewModel
import com.uc.giver.viewModel.BukuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormAddBab : ComponentActivity() {



    private lateinit var babViewModel: BabViewModel



    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var buku_id: String = intent.getIntExtra("buku_id", 0).toString()

            babViewModel =
                ViewModelProvider(this).get(BabViewModel::class.java)
            Scaffold(
                floatingActionButton = {
                    addBabFAB(bukuInt = buku_id.toInt())
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
                                        text = "ADD BAB",
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        fontWeight = FontWeight.SemiBold,
                                    )

                                    Spacer(modifier = Modifier.height(15.dp))

                                    TextField(
                                        value = babViewModel.state.bab_nama,
                                        onValueChange = {
                                            babViewModel.state =
                                                babViewModel.state.copy(bab_nama = it)
                                        },
                                        label = { Text(text = "Nama Bab") },
                                        modifier = Modifier.fillMaxWidth()
                                    )

                                    Spacer(modifier = Modifier.height(15.dp))

                                    Text(text = "Buku ID : $buku_id")
                                    babViewModel.state = babViewModel.state.copy(buku_id = buku_id.toInt(), imageCover = "imageCover", imageBanner = "imageBanner")
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
fun addBabFAB(bukuInt: Int) {
    FloatingAppBtn(0, bukuInt = bukuInt, 0)
}