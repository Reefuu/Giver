package com.uc.giver.view

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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.giver.model.DataX
import com.uc.giver.ui.theme.*
import com.uc.giver.view.widgets.FilterBtn
import com.uc.giver.view.widgets.FloatingAppBtn
import com.uc.giver.view.widgets.PelajaranCard
import com.uc.giver.viewModel.PelajaranViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var pljrnViewModel: PelajaranViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val kelas = intent.getIntExtra("kelas", 1)


        pljrnViewModel = ViewModelProvider(this).get(PelajaranViewModel::class.java)

        if (kelas == 1) {
            pljrnViewModel.getAllDataPljrn()

            pljrnViewModel.dataPljrn.observe(this, Observer { response ->
                setContent {
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = { /* ... */ }) {
                                Icon(Icons.Filled.Add, null)
                            }
                        },
                        // Defaults to FabPosition.End
                        floatingActionButtonPosition = FabPosition.End
                    ) {
                        // Screen content
                        GiverTheme {
                            // A surface container using the 'background' color from the theme
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = SoftWhite,
                            ) {
                                Column {
                                    btnFilter()
                                    PljrnList(pljrn = response)
                                    FAB()
                                }
                            }
                        }
                    }
                }
            })
        } else {
            pljrnViewModel.getDataPljrnKelas(kelas)

            pljrnViewModel.dataPljrnKelas.observe(this, Observer { response ->
                setContent {
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = { /* ... */ }) {
                                Icon(Icons.Filled.Add, null)
                            }
                        },
                        // Defaults to FabPosition.End
                        floatingActionButtonPosition = FabPosition.End
                    ) {
                        GiverTheme {
                            // A surface container using the 'background' color from the theme
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = SoftWhite,
                            ) {
                                Column {
                                    btnFilter()

                                    PljrnList(pljrn = response)
                                }
                            }
                        }
                    }
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
    FloatingAppBtn()
}


