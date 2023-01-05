package com.uc.giver.view.widgets

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.uc.giver.model.DataXXX
import com.uc.giver.ui.theme.*
import com.uc.giver.view.SubbabActivity

//@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
//@Composable
//fun SubbabCard(dataSubbab: DataXXX) {
//
//    val mContext = LocalContext.current as? Activity
//
//    Surface(
//        modifier = Modifier
//            .padding(vertical = 8.dp)
////            .fillMaxWidth()
//            .width(340.dp),
//
//        shape = RoundedCornerShape(16.dp), shadowElevation = 8.dp, color = AppBlueBG,
//        onClick = {
//            val intent = Intent(mContext, SubbabActivity::class.java)
//            intent.putExtra("subbab", dataSubbab.subbab_id)
//            mContext?.startActivity(intent)
//            mContext?.finish()
//        }
//    ) {
//        Row(
//            horizontalArrangement = Arrangement.Start,
//            modifier = Modifier
//                .padding(horizontal = 24.dp, vertical = 16.dp)
//        ) {
//
//            GlideImage(
//                model = dataSubbab.imageBanner,
//                contentDescription = null,
//            )
//
//            Column(
//                verticalArrangement = Arrangement.Center,
//                modifier = Modifier
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = dataSubbab.materi,
//                    fontWeight = FontWeight.SemiBold,
//                    modifier = Modifier
//                        .padding(top = 24.dp)
//                )
//            }
//        }
//    }
//}

@Composable
fun Subbab(dataSubbab: DataXXX, namaBab:String) {
    val mContext = LocalContext.current as? Activity

    Column(
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = com.uc.giver.R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .border(
                    BorderStroke(1.dp, Color.Black)
                )
        )
        Row(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Button(onClick = {

            }, colors = ButtonDefaults.buttonColors(containerColor = filterBlue),modifier = Modifier
                .padding(start = 16.dp, end = 4.dp)
            ){
                Text(text = namaBab, color = filterTextBlue)
            }
            Spacer(modifier = Modifier.weight(1f))

        }
        val scroll = rememberScrollState(0)
        Text(
            text = dataSubbab.materi,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth().height(300.dp)
                .verticalScroll(scroll)
                .padding(start = 16.dp, end = 16.dp)
        )
        Row(
            modifier = Modifier.padding(vertical = 32.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {

            }, colors = ButtonDefaults.buttonColors(containerColor = quizGreenBtn),modifier = Modifier
                .padding(start = 16.dp, end = 4.dp).height(50.dp)
            ){
                Text(text = "TAKE QUIZ", color = quizGreenText)
            }
        }
    }
}