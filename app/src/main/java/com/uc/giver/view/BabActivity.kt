package com.uc.giver.view

import android.annotation.SuppressLint
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
import com.uc.giver.model.Data
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.view.widgets.BabCard
import com.uc.giver.viewModel.BabViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BabActivity : ComponentActivity() {

    private lateinit var babViewModel: BabViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val buku = intent.getIntExtra("buku", 1)


        babViewModel = ViewModelProvider(this).get(BabViewModel::class.java)

        babViewModel.getDataBabBuku(buku)

        babViewModel.dataBabBuku.observe(this, Observer { response ->
            setContent {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /* ... */ }) {
                            Icon(Icons.Filled.Add, null)
                        }
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
                                    BabList(bab = response)
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
fun BabList(bab: ArrayList<Data>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items = bab) { index, item ->
            BabCard(dataBab = item)
        }

    }
}