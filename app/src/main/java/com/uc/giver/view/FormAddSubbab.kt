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
import com.uc.giver.viewModel.SubbabViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormAddSubbab : ComponentActivity() {



    private lateinit var subbabViewModel: SubbabViewModel



    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var bab_id: String = intent.getIntExtra("bab_id", 0).toString()

            subbabViewModel =
                ViewModelProvider(this).get(SubbabViewModel::class.java)
            Scaffold(
                floatingActionButton = {
                    addSubbabFAB(babInt = bab_id.toInt())
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
                                        text = "ADD MATERI",
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        fontWeight = FontWeight.SemiBold,
                                    )

                                    Spacer(modifier = Modifier.height(15.dp))

                                    TextField(
                                        value = subbabViewModel.state.materi,
                                        onValueChange = {
                                            subbabViewModel.state =
                                                subbabViewModel.state.copy(materi = it)
                                        },
                                        label = { Text(text = "Materi") },
                                        modifier = Modifier.fillMaxWidth()
                                    )

                                    Spacer(modifier = Modifier.height(15.dp))

                                    Text(text = "Bab ID : $bab_id")
                                    subbabViewModel.state = subbabViewModel.state.copy(bab_id = bab_id.toInt(), imageBanner = "imageBanner")
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
fun addSubbabFAB(babInt: Int) {
    FloatingAppBtn(0, 0, babInt = babInt)
}