@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.stockanalysis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stockanalysis.ui.theme.StockAnalysisTheme
import android.content.Intent
import android.content.Context
import androidx.compose.material3.TextButton
import androidx.compose.ui.platform.LocalContext

// the Main activity show welcome animation and direct to login afterward


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockAnalysisTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {
                    Greeting()
            }
        }
    }
}}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    val fcontext = LocalContext.current
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        var user by remember {
            mutableStateOf(TextFieldValue(""))
        }
        var password by remember {
            mutableStateOf(TextFieldValue(""))
        }
        Row {
            TextField(value = user,
                onValueChange = {user= it},
                label = {
                Text(text = "User name")
            })
        }
        Row {
             TextField(value = password,
                 onValueChange = {password= it},
                 label = {
                Text(text = "Password")
            },
                 visualTransformation = PasswordVisualTransformation())
        }

        TextButton(onClick = {
            fcontext.startActivity(Intent(fcontext,ResetPassword::class.java))
        }) {
            Text(text = "Forgot Password ?", color = Color.Blue)
        }
        Button(onClick = {
            if (user.text == "kham" && password.text == "tran"){
                fcontext.startActivity(Intent(fcontext, Home::class.java))
            }
        }) {
            Text(text = "Log in")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StockAnalysisTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Greeting()
        }
    }
}