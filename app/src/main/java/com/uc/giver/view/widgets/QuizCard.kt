package com.uc.giver.view.widgets

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.uc.giver.helper.Const
import com.uc.giver.model.DataXQuiz
import com.uc.giver.model.DataXXX
import com.uc.giver.ui.theme.*
import com.uc.giver.view.MainActivity
import com.uc.giver.view.QuizActivity
import com.uc.giver.viewModel.QuizViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quiz(dataQuiz: DataXQuiz, namaSubbab: String) {
//    var questionIndex = remember {
//        mutableStateOf(0)
//    }
//
//    val questionList = questionViewModel.dataQuizSubbab.toString()
    val mContext = LocalContext.current as? Activity
    val myContext = LocalContext.current as ViewModelStoreOwner
    var quizViewModel = ViewModelProvider(myContext).get(QuizViewModel::class.java)
    Const.jawaban = dataQuiz.jawaban

    Surface(
        modifier = Modifier
            .padding(top = 30.dp)
            .width(340.dp)
            .height(500.dp),
        shape = RoundedCornerShape(16.dp),
        color = AppBlueBG
    ) {
        Column() {
            Text(
                text = dataQuiz.pertanyaan,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            )
            OutlinedTextField(
                value = quizViewModel.state.jawaban,
                onValueChange = {
                    quizViewModel.state = quizViewModel.state.copy(
                        jawaban = it
                    )
                },
                label = { Text(text = "Jawaban") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 16.dp),
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {


                    val intent = Intent(mContext, MainActivity::class.java)
                    intent.putExtra("kelas", 1)
                    if (quizViewModel.state.jawaban == Const.jawaban){
                        Toast.makeText(mContext, "BENAR! +50 Koin", Toast.LENGTH_SHORT).show()
                        Const.koin += 50
                    }else{
                        Toast.makeText(mContext, "COBA LAGI", Toast.LENGTH_SHORT).show()
                    }
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    mContext?.startActivity(intent)
                    mContext?.finish()
                }, colors = ButtonDefaults.buttonColors(containerColor = quizGreenBtn),modifier = Modifier
                    .padding(start = 16.dp, end = 4.dp)
                    .height(50.dp)
                ){
                    Text(text = "SUBMIT", color = quizGreenText)
                }
            }

        }
    }
}