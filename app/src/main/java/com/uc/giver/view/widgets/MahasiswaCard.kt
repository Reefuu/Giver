package com.uc.giver.view.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uc.giver.model.Data

@Composable
fun MahasiswaCard(dataMhs: Data) {

//    val mContext = LocalContext.current

    Surface(
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp), shadowElevation = 8.dp,
        onClick = {
//            val intent = Intent(mContext, MovieDetail::class.java)
//            intent.putExtra("movie_id", movie.id)
//            mContext.startActivity(intent)
        }
    ) {
        
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = "NIM : " + dataMhs.nim,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Nama : " + dataMhs.name,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Gender : " + dataMhs.gender,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Fakultas : " + dataMhs.fakultas,
            )
            Text(
                text = "Prodi : " + dataMhs.prodi,
            )
        }
        
    }

}