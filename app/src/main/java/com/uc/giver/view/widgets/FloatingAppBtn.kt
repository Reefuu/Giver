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
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.view.BukuActivity
import com.uc.giver.view.FormAddPelajaran
import com.uc.giver.view.MainActivity
import com.uc.giver.viewModel.BabViewModel
import com.uc.giver.viewModel.BukuViewModel
import com.uc.giver.viewModel.PelajaranViewModel


@Composable
fun FloatingAppBtn() {

    val mContext = LocalContext?.current as Activity?
    val viewModelStoreOwner = when (mContext) {
        is Activity -> mContext as ViewModelStoreOwner
        else -> throw IllegalStateException("mContext is not an Activity")
    }

    var pljrnViewModel: PelajaranViewModel = ViewModelProvider(viewModelStoreOwner).get(PelajaranViewModel::class.java)
    var bkuViewModel: BukuViewModel = ViewModelProvider(viewModelStoreOwner).get(BukuViewModel::class.java)
    var bbViewModel: BabViewModel = ViewModelProvider(viewModelStoreOwner).get(BabViewModel::class.java)

    val className = mContext?.javaClass?.simpleName

    lateinit var intent: Intent

    when(className){
        "MainActivity" -> intent = Intent(mContext, FormAddPelajaran::class.java)
        "FormAddPelajaran" -> intent = Intent(mContext, MainActivity::class.java)
    }


    FloatingActionButton(onClick = {
        when(className){
            "FormAddPelajaran" -> pljrnViewModel.addPljrn()
        }
        mContext?.startActivity(intent)
       if (className.contains("Form")){
           mContext?.finish()
           mContext?.finish()
       }
    }) {
        Icon(Icons.Filled.Add, null)
    }
}