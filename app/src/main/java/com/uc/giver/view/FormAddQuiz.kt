package com.uc.giver.view

import com.uc.giver.viewModel.QuizViewModel
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
class FormAddQuiz : ComponentActivity() {



    private lateinit var quizViewModel: QuizViewModel



    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var subbab_id: String = intent.getIntExtra("subbab", 0).toString()

            quizViewModel =
                ViewModelProvider(this).get(QuizViewModel::class.java)
            Scaffold(
                floatingActionButton = {
                    addQuizFab(subbabInt = subbab_id.toInt())
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
                                        text = "ADD QUIZ",
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        fontWeight = FontWeight.SemiBold,
                                    )

                                    Spacer(modifier = Modifier.height(15.dp))

                                    TextField(
                                        value = quizViewModel.state.pertanyaan,
                                        onValueChange = {
                                            quizViewModel.state =
                                                quizViewModel.state.copy(pertanyaan = it)
                                        },
                                        label = { Text(text = "Pertanyaan") },
                                        modifier = Modifier.fillMaxWidth()
                                    )


                                    Spacer(modifier = Modifier.height(15.dp))
                                    TextField(
                                        value = quizViewModel.state.jawaban,
                                        onValueChange = {
                                            quizViewModel.state =
                                                quizViewModel.state.copy(jawaban = it)
                                        },
                                        label = { Text(text = "Jawaban") },
                                        modifier = Modifier.fillMaxWidth()
                                    )


                                    Spacer(modifier = Modifier.height(15.dp))

                                    Text(text = "subbab_id : $subbab_id")
                                    quizViewModel.state = quizViewModel.state.copy(subbab_id = subbab_id.toInt())
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
fun addQuizFab(subbabInt: Int) {
    FloatingAppBtn(0, 0, babInt = 0, subbabInt = subbabInt)
}