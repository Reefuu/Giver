package com.uc.giver.view.widgets

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.uc.giver.ui.theme.SoftBlack
import com.uc.giver.view.MainActivity

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AccountBtn() {
    val mContext = LocalContext.current as? Activity

    Row() {
        Spacer(modifier = Modifier.weight(1f))
        GlideImage(
            model = "https://via.placeholder.com/200x300.jpg",
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 4.dp)
                .size(50.dp)
                .clip(CircleShape)
                .border(1.dp, SoftBlack, CircleShape)
                .clickable {
                    val intent = Intent(mContext, MainActivity::class.java)
                    intent.putExtra("kelas", 1)
                    mContext?.startActivity(intent)
                    mContext?.finish()
                },
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}