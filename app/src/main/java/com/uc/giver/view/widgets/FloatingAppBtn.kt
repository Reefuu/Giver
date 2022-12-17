package com.uc.giver.view.widgets

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.view.BukuActivity
import com.uc.giver.view.FormAddPelajaran


@Composable
fun FloatingAppBtn() {

    val mContext = LocalContext?.current as Activity?

    val intent = Intent(mContext, FormAddPelajaran::class.java)

    FloatingActionButton(onClick = {
        mContext?.startActivity(intent)
    }) {
        Icon(Icons.Filled.Add, null)
    }
}