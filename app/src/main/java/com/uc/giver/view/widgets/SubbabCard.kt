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

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SubbabCard(dataSubbab: DataXXX) {

    val mContext = LocalContext.current as? Activity

    Surface(
        modifier = Modifier
            .padding(vertical = 8.dp)
//            .fillMaxWidth()
            .width(340.dp),

        shape = RoundedCornerShape(16.dp), shadowElevation = 8.dp, color = AppBlueBG,
        onClick = {
            val intent = Intent(mContext, SubbabActivity::class.java)
            intent.putExtra("subbab", dataSubbab.subbab_id)
            mContext?.startActivity(intent)
            mContext?.finish()
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {

            GlideImage(
                model = dataSubbab.imageBanner,
                contentDescription = null,
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = dataSubbab.materi,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Subbab() {
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
                Text(text = "Bilangan", color = filterTextBlue)
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = {

            }, colors = ButtonDefaults.buttonColors(containerColor = filterOrange), modifier = Modifier
                .padding(start = 4.dp, end = 16.dp)
            ) {
                Text(text = "Kelas 7", color = filterTextOrange)
            }

        }
        val scroll = rememberScrollState(0)
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis at pretium lectus, vel dignissim quam. Sed vestibulum mattis eleifend. Interdum et malesuada fames ac ante ipsum primis in faucibus. Suspendisse vel egestas tortor. Mauris vitae arcu nec urna eleifend volutpat ac vitae ex. Nam quis maximus est. Vivamus placerat turpis sapien, eu gravida sapien aliquet sed. Suspendisse nunc lectus, congue eget posuere in, auctor non mi. Fusce pulvinar risus quis purus ultrices consequat. Nunc ac aliquet arcu. Nunc enim massa, ultricies fermentum iaculis vitae, vehicula vel nibh. Duis varius vel nibh et semper. Donec viverra velit vitae nunc bibendum, ut condimentum turpis auctor. Aliquam vel erat felis. Phasellus faucibus pellentesque leo, nec lacinia nulla elementum nec.\n" +
                    "\n" +
                    "Maecenas gravida lorem elementum purus laoreet, vel eleifend nunc placerat. Vivamus et auctor tortor. Sed facilisis scelerisque augue at feugiat. Etiam nec convallis ipsum, et eleifend ante. Morbi sit amet lectus vestibulum, aliquam nibh eu, placerat dui. Sed sed venenatis risus. Aliquam erat volutpat. Donec lorem arcu, hendrerit venenatis convallis sed, imperdiet in erat. Etiam aliquet eget diam eu sagittis.\n" +
                    "\n" +
                    "Pellentesque sagittis pharetra arcu, vel congue libero euismod id. Phasellus fringilla aliquam finibus. Fusce consectetur porta ante, eu lobortis dolor feugiat nec. Pellentesque nec feugiat sapien. Pellentesque maximus leo a rutrum suscipit. Aenean ornare sed enim in venenatis. Morbi dolor augue, lacinia sed urna vitae, finibus aliquam quam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nunc cursus pretium laoreet.\n" +
                    "\n" +
                    "Proin lacinia condimentum nunc, quis posuere odio mattis et. Phasellus placerat ac diam ut congue. Duis commodo metus a nisi aliquam, et pellentesque nulla sollicitudin. Morbi elementum nibh accumsan sapien scelerisque ultricies. Quisque non efficitur ligula. Donec sapien risus, cursus at semper in, feugiat ac tortor. Cras leo lectus, imperdiet malesuada erat ut, sagittis fringilla sem.\n" +
                    "\n" +
                    "Mauris euismod eleifend turpis sit amet hendrerit. Donec a nibh nec nulla pretium tempus. Sed sagittis nibh sit amet sem suscipit fermentum. Duis sed facilisis nisi, eget aliquet mauris. Phasellus vel justo rutrum, lacinia quam quis, congue metus. Fusce a turpis lorem. Pellentesque posuere turpis leo, tristique tincidunt nisl bibendum sit amet. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut eleifend dui vitae justo lobortis, nec aliquet dolor convallis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Ut aliquam neque elit, vitae lacinia velit ultricies ac. Vestibulum ut efficitur justo. Mauris pulvinar libero non metus consequat, id faucibus lacus volutpat. Nullam vulputate ullamcorper turpis ut sodales. Integer vel augue at metus auctor pharetra. Nam tempor molestie urna eget ultricies.",
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth().height(450.dp)
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
                .padding(start = 16.dp, end = 4.dp).height(130.dp)
            ){
                Text(text = "TAKE QUIZ", color = quizGreenText)
            }
        }
    }
}