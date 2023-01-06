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
import com.uc.giver.helper.Const
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.view.*
import com.uc.giver.viewModel.*


@Composable
fun FloatingAppBtn(pelajaranInt: Int, bukuInt: Int, babInt: Int, subbabInt: Int) {

    if (Const.uname == "admin"){
        val mContext = LocalContext?.current as Activity?
        val viewModelStoreOwner = when (mContext) {
            is Activity -> mContext as ViewModelStoreOwner
            else -> throw IllegalStateException("mContext is not an Activity")
        }

        var pljrnViewModel: PelajaranViewModel = ViewModelProvider(viewModelStoreOwner).get(PelajaranViewModel::class.java)
        var bkuViewModel: BukuViewModel = ViewModelProvider(viewModelStoreOwner).get(BukuViewModel::class.java)
        var bbViewModel: BabViewModel = ViewModelProvider(viewModelStoreOwner).get(BabViewModel::class.java)
        var sbViewModel: SubbabViewModel = ViewModelProvider(viewModelStoreOwner).get(SubbabViewModel::class.java)
        var qzViewModel: QuizViewModel = ViewModelProvider(viewModelStoreOwner).get(QuizViewModel::class.java)

        val className = mContext?.javaClass?.simpleName

        lateinit var intent: Intent

        when(className){
            "MainActivity" -> intent = Intent(mContext, FormAddPelajaran::class.java)
            "FormAddPelajaran" -> intent = Intent(mContext, MainActivity::class.java)
            "BukuActivity" -> intent = Intent(mContext, FormAddBuku::class.java)
            "FormAddBuku" -> intent = Intent(mContext, BukuActivity::class.java)
            "BabActivity" -> intent = Intent(mContext, FormAddBab::class.java)
            "FormAddBab" -> intent = Intent(mContext, BabActivity::class.java)
            "SubbabActivity" -> intent = Intent(mContext, FormAddSubbab::class.java)
            "FormAddSubbab" -> intent = Intent(mContext, SubbabActivity::class.java)
            "QuizActivity" -> intent = Intent(mContext, FormAddQuiz::class.java)
            "FormAddQuiz" -> intent = Intent(mContext, QuizActivity::class.java)
        }


        FloatingActionButton(onClick = {
            when(className){
                "FormAddPelajaran" -> pljrnViewModel.addPljrn()
                "BukuActivity" -> intent.putExtra("pelajaran_id", pelajaranInt)
                "FormAddBuku" -> {
                    intent.putExtra("pelajaran", pelajaranInt)
                    bkuViewModel.addBuku()
                }
                "BabActivity" -> intent.putExtra("buku_id", bukuInt)
                "FormAddBab" -> {
                    intent.putExtra("buku", bukuInt)
                    bbViewModel.addBab()
                }
                "SubbabActivity" -> intent.putExtra("bab_id", babInt)
                "FormAddSubbab" -> {
                    intent.putExtra("bab", babInt)
                    sbViewModel.addSubbab()
                }
                "QuizActivity" -> intent.putExtra("subbab", subbabInt)
                "FormAddQuiz" -> {
                    intent.putExtra("subbab", subbabInt)
                    qzViewModel.addQuiz()
                }
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


}