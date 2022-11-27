package com.uc.giver.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.giver.model.Data
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.view.widgets.MahasiswaCard
import com.uc.giver.viewModel.MahasiswaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var mhsViewModel: MahasiswaViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mhsViewModel = ViewModelProvider(this).get(MahasiswaViewModel::class.java)

        mhsViewModel.getAllDataMhsw()

        mhsViewModel.dataMhs.observe(this, Observer { response ->
            setContent {
                GiverTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MhsList(mhsList = response)
                    }
                }
            }
        })
    }
}

@Composable
fun MhsList(mhsList: ArrayList<Data>) {
    LazyColumn(){
        itemsIndexed(items = mhsList){index, item ->
            MahasiswaCard(dataMhs = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GiverTheme {
    }
}