package com.uc.giver.view.widgets

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.uc.giver.model.Data
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.view.BabActivity

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BabCard(dataBab: Data) {

    val mContext = LocalContext.current as? Activity

    Surface(
        modifier = Modifier
            .padding(vertical = 8.dp)
//            .fillMaxWidth()
            .width(340.dp)
        ,

        shape = RoundedCornerShape(16.dp), shadowElevation = 8.dp, color = AppBlueBG,
        onClick = {
            val intent = Intent(mContext, BabActivity::class.java)
            intent.putExtra("buku", dataBab.buku_id)
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
                model = dataBab.image_cover,
                contentDescription = null,
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = dataBab.bab_nama,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )
            }
        }
    }
}