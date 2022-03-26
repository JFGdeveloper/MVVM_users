package com.javidev.mvvm_user_yayo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
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
                }
            }
        }
    }
}
