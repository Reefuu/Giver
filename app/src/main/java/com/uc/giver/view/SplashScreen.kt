package com.uc.giver.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.uc.giver.ui.theme.AppBlueBG
import com.uc.giver.ui.theme.GiverTheme
import com.uc.giver.ui.theme.SoftWhite
import kotlinx.coroutines.delay

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiverTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    AnimatedSplashScreen()
                }
            }
        }
    }
}

@Composable
fun AnimatedSplashScreen(){
    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    val mContext = LocalContext.current as? Activity


    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)

        val intent = Intent(mContext, MainActivity::class.java)
        intent.putExtra("kelas", 1)
        mContext?.startActivity(intent)
        mContext?.finish()



//        val intent = Intent(mContext, MovieDetail::class.java)
//        intent.putExtra("movie_id", movie.id)
//        mContext.startActivity(intent)

//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//        finish()
    }

    Splash(alphaAnim.value)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Splash(alpha: Float){
    Box(modifier = Modifier
        .background(AppBlueBG)
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
//        Icon(
//            modifier = Modifier
//                .size(120.dp)
//                .alpha(alpha = alpha),
//            imageVector = Icons.Default.Home,
//            contentDescription = "Logo ICON",
//            tint = SoftWhite)

        GlideImage(
            model = "https://i.postimg.cc/zvwbtndw/09-F557-DA-A787-4484-830-A-BB2-D6-F2-FB920.png",
            contentDescription = null,
            modifier = Modifier
                .alpha(alpha = alpha)
                .size(1000.dp)
        )
    }
}