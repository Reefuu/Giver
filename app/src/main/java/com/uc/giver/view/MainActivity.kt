package com.uc.giver.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.giver.model.Data
import com.uc.giver.model.DataX
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import com.uc.giver.view.widgets.PelajaranCard
import com.uc.giver.viewModel.PelajaranViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var pljrnViewModel: PelajaranViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pljrnViewModel = ViewModelProvider(this).get(PelajaranViewModel::class.java)

        pljrnViewModel.getAllDataPljrn()

        pljrnViewModel.dataPljrn.observe(this, Observer { response ->
            setContent {
                GiverTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = SoftWhite,

                    ) {

                        PljrnList(pljrn = response)
                    }
                }
            }
        })
    }
}


@Composable
fun PljrnList(pljrn: ArrayList<DataX>) {
    LazyColumn(){
        itemsIndexed(items = pljrn){index, item ->
            PelajaranCard(dataPljrn = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GiverTheme {
    }
}