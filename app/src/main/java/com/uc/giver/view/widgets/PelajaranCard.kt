package com.uc.giver.view.widgets

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.uc.giver.model.DataX
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.view.BabActivity
import com.uc.giver.view.BukuActivity


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PelajaranCard(dataPljrn: DataX) {

    val mContext = LocalContext.current as? Activity

    Surface(
        modifier = Modifier
            .padding(vertical = 8.dp)
//            .fillMaxWidth()
            .width(340.dp)
        ,

    shape = RoundedCornerShape(16.dp), shadowElevation = 8.dp, color = AppBlueBG,
        onClick = {
            val intent = Intent(mContext, BukuActivity::class.java)
            intent.putExtra("pelajaran", dataPljrn.pelajaran_id)
            mContext?.startActivity(intent)
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {

            GlideImage(
                model = "https://via.placeholder.com/200x300.jpg",
                contentDescription = null,
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = dataPljrn.nama_pelajaran,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 6.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,   
                )
                Text(
                    text = "Kelas : "
                            + dataPljrn.kelas,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 22.dp)
                )
            }
        }
    }
}