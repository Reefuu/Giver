package com.uc.giver.view.widgets

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uc.giver.model.DataX
import com.uc.giver.ui.theme.*
import com.uc.giver.view.MainActivity

@Composable
fun FilterBtn(){
    val mContext = LocalContext.current as? Activity
    Row() {
        Button(onClick = {
            val intent = Intent(mContext, MainActivity::class.java)
            intent.putExtra("kelas", 1)
            mContext?.startActivity(intent)
            mContext?.finish()
        }, colors = ButtonDefaults.buttonColors(containerColor = filterBlue),modifier = Modifier
            .padding(start = 16.dp, end = 4.dp)
        ){
            Text(text = "ALL", color = filterTextBlue)
        }
        Button(onClick = {
            val intent = Intent(mContext, MainActivity::class.java)
            intent.putExtra("kelas", 7)
            mContext?.startActivity(intent)
            mContext?.finish()
        }, colors = ButtonDefaults.buttonColors(containerColor = filterYellow), modifier = Modifier
            .padding(start = 4.dp, end = 4.dp)
        ) {
            Text(text = "Kelas 7", color = filterTextYellow)
        }
        Button(onClick = {
            val intent = Intent(mContext, MainActivity::class.java)
            intent.putExtra("kelas", 8)
            mContext?.startActivity(intent)
            mContext?.finish()
        }, colors = ButtonDefaults.buttonColors(containerColor = filterOrange), modifier = Modifier
            .padding(start = 4.dp, end = 4.dp)
        ) {
            Text(text = "Kelas 8", color = filterTextOrange)
        }
        Button(onClick = {
            val intent = Intent(mContext, MainActivity::class.java)
            intent.putExtra("kelas", 9)
            mContext?.startActivity(intent)
            mContext?.finish()
        }, colors = ButtonDefaults.buttonColors(containerColor = filterPink), modifier = Modifier
            .padding(start = 4.dp, end = 8.dp)
        ) {
            Text(text = "Kelas 9", color = filterTextPink)
        }

    }
}