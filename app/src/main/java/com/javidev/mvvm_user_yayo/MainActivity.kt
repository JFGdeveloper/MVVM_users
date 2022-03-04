package com.javidev.mvvm_user_yayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
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
                    MyApp()
                }
            }
        }
    }
}

// inyecto el viewModel
@Composable
fun MyApp(viewModel: UserViewModel = hiltViewModel()) {

    HomeScreen(){
        viewModel.getUser()
    }

}

@Composable
fun HomeScreen(
    addClick: (() -> Unit)? = null
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = " el puto amo no lo tiene claro") },
                actions = {
                    IconButton(onClick = { addClick?.invoke() }) {
                        Icon(Icons.Filled.Add, null)
                    }
                }


            )
        }

    ) {}


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVM_user_yayoTheme {
        HomeScreen(){}
    }
}