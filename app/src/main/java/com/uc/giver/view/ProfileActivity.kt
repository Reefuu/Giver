package com.uc.giver.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.uc.giver.helper.Const
import com.uc.giver.ui.theme.*
import com.uc.giver.viewModel.PelajaranViewModel
import com.uc.giver.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class ProfileActivity : ComponentActivity() {
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val nama = Const.uname

        userViewModel.getDataUser()

        userViewModel.dataUser.observe(this, Observer { response ->
            response.forEach {
                if (it.nama == nama){
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
                            .verticalScroll(rememberScrollState())
                    ) {
                        ProfileYes(userViewModel = userViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileYes(userViewModel: UserViewModel) {
    Column() {
        MyProfileCard(userViewModel = userViewModel)
    }
}

@Composable
fun MyProfileCard(userViewModel: UserViewModel) {
    val mContext = LocalContext.current

    val displayMetrics = mContext.resources.displayMetrics
    val screenHeight = displayMetrics.heightPixels
    val screenHeightDp = screenHeight.div(displayMetrics.density)

    val secHeight = screenHeightDp * 0.35

    val maxHeight = screenHeightDp * 0.65

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(secHeight.dp),
        color = AppBlueBG
    ) {
        ContentUpProfile(userViewModel = userViewModel)
    }

    Surface(
        shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(maxHeight.dp),
        color = SoftWhite
    ) {
        ContentProfile()
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ContentUpProfile(userViewModel: UserViewModel) {
    lateinit var topText: String
    lateinit var underText: String



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        GlideImage(
            model = "https://via.placeholder.com/200x300.jpg",
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 4.dp)
                .size(100.dp)
                .clip(CircleShape)
                .border(1.dp, SoftBlack, CircleShape),
            contentScale = ContentScale.Crop,
        )

        topText = userViewModel.state.nama
        underText = userViewModel.state.email

        Text(
            text = topText,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        Text(
            text = underText,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = SoftBlack,
        )
    }
}

@Composable
fun ContentProfile(){
    Column() {
        val mContext = LocalContext.current as Activity
        Text(text = "Koin = ${Const.koin} (temporary)", modifier = Modifier.padding(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Button(onClick = {


                val intent = Intent(mContext, RewardActivity::class.java)
                mContext?.startActivity(intent)
                mContext?.finish()
            }, colors = ButtonDefaults.buttonColors(containerColor = quizGreenBtn),modifier = Modifier
                .padding(start = 16.dp, end = 4.dp)
                .height(50.dp)
            ){
                Text(text = "Reward Page", color = quizGreenText)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 64.dp).fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(onClick = {
                Const.koin = 0
                Const.uname = ""
                Const.jawaban = ""
                val intent = Intent(mContext, LogRegActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                mContext?.startActivity(intent)
                mContext?.finish()
            }, colors = ButtonDefaults.buttonColors(containerColor = logoutBtn),modifier = Modifier
                .padding(start = 16.dp, end = 4.dp)
                .height(50.dp)
            ){
                Text(text = "LOGOUT", color = SoftWhite, fontWeight = FontWeight.ExtraBold)
            }
        }
    }
}