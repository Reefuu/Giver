package com.uc.giver.view.widgets

import android.app.Activity
import android.view.WindowManager
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.uc.giver.model.DataXQuiz
import com.uc.giver.model.DataXXX
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.ui.theme.filterTextBlue
import com.uc.giver.viewModel.QuizViewModel

@Composable
fun Quiz(dataQuiz: DataXQuiz, namaSubbab:String) {
//    var questionIndex = remember {
//        mutableStateOf(0)
//    }
//
//    val questionList = questionViewModel.dataQuizSubbab.toString()
    val mContext = LocalContext.current as? Activity

Surface(

    modifier = Modifier
        .padding(vertical = 100.dp).width(340.dp).height(500.dp),
        shape = RoundedCornerShape(16.dp),
        color = AppBlueBG

    ){
    Row( ) {

    }
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {

//        ShowProgress()



        Row() {
            Text(
                text = dataQuiz.pertanyaan,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth().height(100.dp)
                    .padding(start = 16.dp, end = 16.dp)
            )
        }



    }
}
}