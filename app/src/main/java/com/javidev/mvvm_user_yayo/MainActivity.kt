package com.javidev.mvvm_user_yayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.javidev.mvvm_user_yayo.mvvm.UserViewModel
import com.javidev.mvvm_user_yayo.ui.theme.MVVM_user_yayoTheme
import dagger.hilt.android.AndroidEntryPoint

// 2b añado etiqueta entrypoing
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVM_user_yayoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("New User")
                }
            }
        }
    }
}

// inyecto el viewModel
@Composable
fun Greeting(name: String,viewModel: UserViewModel = hiltViewModel()) {

    Button(onClick = { viewModel.getUser() }) {
        Text(text = name)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVM_user_yayoTheme {
        Greeting("Android")
    }
}