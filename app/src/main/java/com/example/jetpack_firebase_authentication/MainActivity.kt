package com.example.jetpack_firebase_authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.Lottie
import com.example.jetpack_firebase_authentication.ui.theme.Jetpack_FirebaseAuthenticationTheme
import com.example.jetpack_firebase_authentication.ui.theme.Purple500
import com.google.firebase.auth.FirebaseAuth
import com.airbnb.lottie.LottieAnimationView


class MainActivity : ComponentActivity() {
    private val mAuth = FirebaseAuth.getInstance()
    var verificationOtp = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_FirebaseAuthenticationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                   OTPScreen()
                }
            }
        }
    }
}

@Composable
fun OTPScreen() {
    val context = LocalContext.current
    val otpVal: String?=null
    val phoneNumber = remember{ mutableStateOf("")}
    val customView = remember{ LottieAnimationView(context) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "OTP Screen",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = ), contentDescription = "OTP Image")
            
        }
    }
}