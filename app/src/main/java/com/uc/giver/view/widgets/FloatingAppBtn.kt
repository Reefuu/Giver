package com.uc.giver.view.widgets

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uc.giver.ui.theme.AppBlueBG


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FloatingAppBtn(){
//    ExtendedFloatingActionButton(
//        icon = { Icon(Icons.Default.Add,"") },
//        text = { Text("") },
//        onClick = { /*do something*/ },
//        elevation = FloatingActionButtonDefaults.elevation(8.dp)
//    )

    FloatingActionButton(
        modifier = Modifier.size(40.dp),
//        shape = ,
        onClick = {  },
        contentColor = Color.Black
    ){
        Icon(Icons.Filled.Add,null)
    }
}