package com.uc.giver.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.uc.giver.model.DataXX
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.view.widgets.BukuCard
import com.uc.giver.viewModel.BukuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BukuActivity : ComponentActivity() {

    private lateinit var bukuViewModel: BukuViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pelajaran = intent.getIntExtra("pelajaran", 1)


        bukuViewModel = ViewModelProvider(this).get(BukuViewModel::class.java)

        bukuViewModel.getDataBukuPljrn(pelajaran)

        bukuViewModel.dataBukuPljrn.observe(this, Observer { response ->
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
                                BukuList(buku = response)
                            }
                        }
                    }
                }
            }
        })

    }
}


@Composable
fun BukuList(buku: ArrayList<DataXX>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items = buku) { index, item ->
            BukuCard(dataBuku = item)
        }

    }
}