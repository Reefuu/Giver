package com.uc.giver.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.WindowManager.LayoutParams
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.uc.giver.helper.Const
import com.uc.giver.ui.theme.*
import com.uc.giver.viewModel.PelajaranViewModel
import com.uc.giver.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern


@Suppress("DEPRECATION")
@AndroidEntryPoint
class LogRegActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val login = intent.getIntExtra("login", 1)

        window.setSoftInputMode(LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
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
                        LoginRegister(login)
                    }
                }
            }
        }
    }
}

@Composable
fun LoginRegister(login: Int) {
    Column() {
        MyCard(login)
    }
}

@Composable
fun MyCard(login: Int) {
    val mContext = LocalContext.current

    val displayMetrics = mContext.resources.displayMetrics
    val screenHeight = displayMetrics.heightPixels
    val screenHeightDp = screenHeight.div(displayMetrics.density)

    val secHeight = screenHeightDp * 0.25

    val maxHeight = screenHeightDp * 0.75

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(secHeight.dp),
        color = AppBlueBG
    ) {
        ContentUp(login)
    }

    Surface(
        shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(maxHeight.dp),
        color = SoftWhite
    ) {
        Content(login)
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(login: Int) {
    lateinit var userViewModel: UserViewModel
    val mContext = LocalContext.current as ViewModelStoreOwner
    val myContext = LocalContext.current as Activity?
    val my2Context = LocalContext.current as LifecycleOwner
    val regexMail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"
    val patternMail = Pattern.compile(regexMail)

    Column(
    ) {
        userViewModel =
            ViewModelProvider(mContext).get(UserViewModel::class.java)

        Spacer(modifier = Modifier.height(32.dp))

        var usernameErrorMessage by remember { mutableStateOf("") }


        OutlinedTextField(
            value = userViewModel.state.nama,
            onValueChange = {
                userViewModel.state =
                    userViewModel.state.copy(nama = it)
                if (it.length >= 5) {
                    usernameErrorMessage = ""
                } else {
                    usernameErrorMessage = "Username must be at least 5 characters long"
                }
            },
            label = { Text(text = "Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 16.dp),
            singleLine = true,

            )

        if (usernameErrorMessage.isNotEmpty()) {
            Text(
                text = usernameErrorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            )
        }

        if (login != 1) {
            var emailErrorMessage by remember { mutableStateOf("") }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = userViewModel.state.email,
                onValueChange = {
                    userViewModel.state =
                        userViewModel.state.copy(email = it)
                    if (patternMail.matcher(it).matches()) {
                        emailErrorMessage = ""
                    } else {
                        emailErrorMessage = "Invalid email address"
                    }

                },
                label = { Text(text = "Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 8.dp),
                singleLine = true,
            )
            if (emailErrorMessage.isNotEmpty()) {
                Text(
                    text = emailErrorMessage,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                )
            }
        }

        var passwordVisible by remember { mutableStateOf(false) }

        Spacer(modifier = Modifier.height(16.dp))

        var passErrorMessage by remember { mutableStateOf("") }

        OutlinedTextField(
            value = userViewModel.state.password,
            onValueChange = {
                userViewModel.state =
                    userViewModel.state.copy(password = it)
                if (it.length >= 8) {
                    passErrorMessage = ""
                } else {
                    passErrorMessage = "Password must be at least 8 characters long"
                }
            },
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 8.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            }
        )
        if (passErrorMessage.isNotEmpty()) {
            Text(
                text = passErrorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            )
        }
        var logregText: String = ""

        val intentToLogin = Intent(myContext, LogRegActivity::class.java)
        intentToLogin.putExtra("login", 1)

        val intentToRegister = Intent(myContext, LogRegActivity::class.java)
        intentToRegister.putExtra("login", 10)

        val intentToHome = Intent(myContext, MainActivity::class.java)
        intentToHome.putExtra("kelas", 1)
        intentToHome.putExtra("uname", userViewModel.state.nama)

        lateinit var intent: Intent

        lateinit var botText1: String
        lateinit var botText2: AnnotatedString

        if (login != 1) {
            logregText = "REGISTER"
            intent = intentToLogin
            botText1 = "Already have an account? "
            botText2 = AnnotatedString("Sign In!")
        } else {
            logregText = "SIGN IN"
            intent = intentToHome
            botText1 = "Don't have an account? "
            botText2 = AnnotatedString("Register Now!")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    if (login != 1){
                        userViewModel.register()
                    }else{
                        userViewModel.login()
                        userViewModel.getDataUser()

                        userViewModel.dataUser.observe(my2Context, Observer { response ->
                            response.forEach {
                                if (it.nama == userViewModel.state.nama){
                                    Const.koin = it.koin
                                }
                            }
                        })
                    }
                    myContext?.startActivity(intent)
                    myContext?.finish()
                },
                colors = ButtonDefaults.buttonColors(logregBlue),
                modifier = Modifier
                    .height(50.dp)
                    .width(130.dp),
            ) {
                Text(
                    text = logregText, fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = SoftWhite,
                )
            }
            lateinit var logOrReg: Intent

            if (login != 1){
                logOrReg = intentToLogin
            }else{
                logOrReg = intentToRegister
            }
            Row(
                modifier =
                    Modifier.fillMaxWidth()
                        .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = botText1,
                    color = SoftBlack,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                )
                ClickableText(
                    text = botText2,
                    onClick = {
                        myContext?.startActivity(logOrReg)
                        myContext?.finish()
                    },
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    ),
                )
            }

        }

    }

}

@Composable
fun ContentUp(login: Int) {
    lateinit var topText: String
    lateinit var underText: String
    if (login == 1) {
        topText = "Welcome Back"
        underText = "Sign in to continue"
    } else {
        topText = "Hello!"
        underText = "Create an account to continue"
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = topText,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = SoftWhite,
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
    Surface(
        color = AppBlueBG
    ) {
        LoginRegister(login = 1)
    }
}