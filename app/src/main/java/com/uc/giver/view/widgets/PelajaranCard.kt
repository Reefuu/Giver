package com.uc.giver.view.widgets

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.uc.giver.model.Data
import com.uc.giver.model.DataX
import com.uc.giver.model.PelajaranData
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.view.MainActivity


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PelajaranCard(dataPljrn: DataX) {

    val mContext = LocalContext.current as? Activity
    val painter = rememberAsyncImagePainter(model = "https://via.placeholder.com/80x100")

    Surface(
        modifier = Modifier
            .padding(16.dp, 8.dp)
//            .fillMaxWidth()
            .width(300.dp)
        ,

    shape = RoundedCornerShape(12.dp), shadowElevation = 8.dp, color = AppBlueBG,
        onClick = {
            val intent = Intent(mContext, MainActivity::class.java)
            mContext?.startActivity(intent)
            mContext?.finish()

        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(16.dp)
        ) {

            GlideImage(
                model = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Android_logo_2019_%28stacked%29.svg/1200px-Android_logo_2019_%28stacked%29.svg.png",
                contentDescription = null,
                modifier = Modifier.padding(16.dp),
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
//                .fillMaxHeight()
            ) {
                Text(
                    text = dataPljrn.nama_pelajaran,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Kelas : "
                            + dataPljrn.kelas,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
            }
        }
//        Column(
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .padding(16.dp)
////                .fillMaxHeight()
//        ) {
//            Text(
//                text = dataPljrn.nama_pelajaran,
//                fontWeight = FontWeight.SemiBold
//            )
//            Text(
//                text = "Kelas : "
//                        + dataPljrn.kelas,
//                fontWeight = FontWeight.SemiBold
//            )
//        }
        
    }

}