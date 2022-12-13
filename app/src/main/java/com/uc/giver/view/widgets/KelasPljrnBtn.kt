package com.uc.giver.view.widgets

import android.app.Activity
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
import com.uc.giver.ui.theme.*

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KelasPljrnBtn(){
    val mContext = LocalContext.current as? Activity
    Row() {
        Button(onClick = {

        }, colors = ButtonDefaults.buttonColors(containerColor = filterBlue),modifier = Modifier
            .padding(start = 16.dp, end = 4.dp)
        ){
            Text(text = "ALL", color = filterTextBlue)
        }
        Button(onClick = {

        }, colors = ButtonDefaults.buttonColors(containerColor = filterYellow), modifier = Modifier
            .padding(start = 4.dp, end = 4.dp)
        ) {
            Text(text = "Kelas 7", color = filterTextYellow)
        }

    }
}