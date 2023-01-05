package com.uc.giver.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.giver.helper.Const
import com.uc.giver.model.DataX
import com.uc.giver.model.DataXXXX
import com.uc.giver.ui.theme.*
import com.uc.giver.view.widgets.AccountBtn
import com.uc.giver.view.widgets.FilterBtn
import com.uc.giver.view.widgets.FloatingAppBtn
import com.uc.giver.view.widgets.PelajaranCard
import com.uc.giver.viewModel.PelajaranViewModel
import com.uc.giver.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var pljrnViewModel: PelajaranViewModel

    private lateinit var userViewModel: UserViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel= ViewModelProvider(this).get(UserViewModel::class.java)

        val kelas = intent.getIntExtra("kelas", 1)
        val nama = intent.getStringExtra("uname")

        if (Const.uname.isEmpty()){
            Const.uname = nama.toString()
        }

        userViewModel.getDataUser()

        userViewModel.dataUser.observe(this, Observer { response ->
            response.forEach {
                if (it.nama == Const.uname){
                    if (Const.koin != it.koin){
                        userViewModel.state = userViewModel.state.copy(koin = Const.koin)
                    }else{
                        userViewModel.state = userViewModel.state.copy(koin = it.koin)
                    }
                    userViewModel.state = userViewModel.state.copy(
                        email = it.email, image = it.image, nama = it.nama, nomor_telepon = it.nomor_telepon, password = it.password
                    )
                    Const.koin = userViewModel.state.koin
                    userViewModel.addKoin()
                }
            }
        })


        pljrnViewModel = ViewModelProvider(this).get(PelajaranViewModel::class.java)

        if (kelas == 1) {
            pljrnViewModel.getAllDataPljrn()

            pljrnViewModel.dataPljrn.observe(this, Observer { response ->
                setContent {
                    Scaffold(
                        floatingActionButton = {
                            FAB()
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
                                        AccBtn(userViewModel.state.nama)
                                        btnFilter()
                                        PljrnList(pljrn = response)
                                    }
                                }
                            }
                        }
                    )
                }
            })
        } else {
            pljrnViewModel.getDataPljrnKelas(kelas)

            pljrnViewModel.dataPljrnKelas.observe(this, Observer { response ->
                setContent {
                    Scaffold(
                        floatingActionButton = {
                            FAB()
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
                                        AccBtn(userViewModel.state.nama)
                                        btnFilter()
                                        PljrnList(pljrn = response)
                                    }
                                }
                            }
                        }
                    )
                }
            })
        }

    }
}


@Composable
fun PljrnList(pljrn: ArrayList<DataX>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items = pljrn) { index, item ->
            PelajaranCard(dataPljrn = item)
        }

    }
}


@Composable
fun btnFilter() {
    Column {
        FilterBtn()
    }
}

@Composable
fun FAB() {
 FloatingAppBtn(0, 0, 0)
}

@Composable
fun AccBtn(uname: String){
    AccountBtn(uname)
}
