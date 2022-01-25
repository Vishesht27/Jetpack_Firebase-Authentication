package com.example.jetpack_firebase_authentication

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.Lottie
import com.example.jetpack_firebase_authentication.ui.theme.Jetpack_FirebaseAuthenticationTheme
import com.example.jetpack_firebase_authentication.ui.theme.Purple500
import com.google.firebase.auth.FirebaseAuth
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable


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

@Preview
@Composable
fun OTPScreen() {
    val context = LocalContext.current
    var otpVal: String?=null
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
                text = "Firebase Authentication",
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

            // Add Lottie file

            
            AndroidView({
                customView
            },
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)

            ){ view ->
                with(view){
                    setAnimation()
                    playAnimation()
                    repeatCount = LottieDrawable.INFINITE
                    foregroundGravity = Gravity.CENTER
                }
            }
            
//            Image(
//                painter = painterResource(id = ),
//                contentDescription = "OTP Image",
//                modifier = Modifier
//                    .width(100.dp)
//                    .height(100.dp)
//            )

            Spacer(modifier = Modifier.height(50.dp))

            OutlinedTextField(
                value = phoneNumber.value,
                onValueChange = {phoneNumber.value=it},
                label = {Text(text="Phone Number")},
                leadingIcon = { Icon(Icons.Filled, contentDescription = "Phone Number") },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(20.dp))
            
            
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .width(45.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Purple500)
            ) {
                Text(text="Send OTP", fontSize = 15.sp, color = Color.White)
            }
            
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Enter the OTP",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            OTPTextFields(length = 4)
            { getOtp ->
                otpVal = getOtp
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = {
                if(otpVal!=null){
                    Toast.makeText(context,"Please Enter OTP",Toast.LENGTH_SHORT).show()
                }
            },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(45.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Purple500)
            ) {
                Text(
                    text = "OTP Verify",
                    fontSize = 15.sp,
                    color =  Color.White
                )
            }
        }
    }
}