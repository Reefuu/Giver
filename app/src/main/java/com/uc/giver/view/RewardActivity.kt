package com.uc.giver.view

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uc.giver.helper.Const
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.ui.theme.GiverTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RewardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContent {
            GiverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = AppBlueBG
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = "Koin : ${Const.koin}")
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Mohon Maaf, Voucher Masih Belum Tersedia")
                    }
                }
            }
        }
    }
}