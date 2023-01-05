package com.uc.giver.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.giver.model.DataXXX
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.view.widgets.FloatingAppBtn
import com.uc.giver.view.widgets.Subbab
import com.uc.giver.viewModel.SubbabViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubbabActivity : ComponentActivity() {

    private lateinit var subbabViewModel: SubbabViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bab = intent.getIntExtra("bab", 1)
        val bab_nama = intent.getStringExtra("bab_nama")


        subbabViewModel = ViewModelProvider(this).get(SubbabViewModel::class.java)

        subbabViewModel.getDataSubbabBab(bab)

        subbabViewModel.dataSubbabBab.observe(this, Observer { response ->
            setContent {
                Scaffold(
                    floatingActionButton = {
                        subbabFAB(babInt = bab)
                    },
                    // Defaults to FabPosition.End
                    floatingActionButtonPosition = FabPosition.End,
                    content = {
                        GiverTheme {
                            // A surface container using the 'background' color from the theme
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = SoftWhite,
                            ) {
                                Column {
                                    if (response != null){
                                        SubbabList(subbab = response, bab_nama.toString())
                                    }else{
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center,
                                        ) {
                                            Text(text = "Masih Belum Ada Materi di Bab Ini!", fontWeight = FontWeight.Bold)
                                        }
                                    }
                                }
                            }
                        }
                    }
                )
            }
        })

    }
}


@Composable
fun SubbabList(subbab: ArrayList<DataXXX>, bab_nama:String) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items = subbab) { index, item ->
            Subbab(dataSubbab = item, namaBab = bab_nama)
        }

    }
}

@Composable
fun subbabFAB(babInt: Int) {
    FloatingAppBtn(pelajaranInt = 0, bukuInt = 0, babInt = babInt, 0)
}