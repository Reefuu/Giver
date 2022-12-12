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
import com.uc.giver.model.DataXXX
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.view.widgets.SubbabCard
import com.uc.giver.viewModel.SubbabViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubbabActivity : ComponentActivity() {

    private lateinit var subbabViewModel: SubbabViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bab = intent.getIntExtra("bab", 1)


        subbabViewModel = ViewModelProvider(this).get(SubbabViewModel::class.java)

        subbabViewModel.getDataSubbabBab(bab)

        subbabViewModel.dataSubbabBab.observe(this, Observer { response ->
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
                                SubbabList(subbab = response)
                            }
                        }
                    }
                }
            }
        })

    }
}


@Composable
fun SubbabList(subbab: ArrayList<DataXXX>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items = subbab) { index, item ->
            SubbabCard(dataSubbab = item)
        }

    }
}