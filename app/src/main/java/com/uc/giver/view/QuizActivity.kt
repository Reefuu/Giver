package com.uc.giver.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.giver.model.DataXQuiz
import com.uc.giver.model.DataXXX
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.view.widgets.FloatingAppBtn
import com.uc.giver.view.widgets.Quiz
import com.uc.giver.view.widgets.Subbab
import com.uc.giver.viewModel.QuizViewModel
import com.uc.giver.viewModel.SubbabViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizActivity : ComponentActivity() {

    private lateinit var quizViewModel: QuizViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val subbab = intent.getIntExtra("subbab", 1)
        val subbab_nama = intent.getStringExtra("subbab_nama")


        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        quizViewModel.getDataQuizSubbab(subbab)


        quizViewModel.dataQuizSubbab.observe(this, Observer { response ->
            setContent {
                Scaffold(
                    floatingActionButton = {
                        quizFAB(subbabInt = subbab)
                    },
                    // Defaults to FabPosition.End
                    floatingActionButtonPosition = FabPosition.End,
                    content = {
                        GiverTheme {
                            // A surface container using the 'background' color from the theme
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = SoftWhite,
                            ) {
                                Column {
                                    if (response != null){
                                        Text(text = "$subbab_nama")
                                        QuizList(subbab = response, subbab_nama.toString())
                                    }else{
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center,
                                        ) {
                                            Text(text = "Masih Belum Ada Quiz di SubBab Ini!", fontWeight = FontWeight.Bold)
                                        }
                                    }
                                }
                            }
                        }
                    }
                )
            }
        })

    }
}


@Composable
fun QuizList(subbab: ArrayList<DataXQuiz>, subbab_nama:String) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items = subbab) { index, item ->
            Quiz(dataQuiz = item, namaSubbab = subbab_nama)
        }

    }
}

@Composable
fun quizFAB(subbabInt: Int) {
    FloatingAppBtn(pelajaranInt = 0, bukuInt = 0, babInt = 0, subbabInt = subbabInt)
}