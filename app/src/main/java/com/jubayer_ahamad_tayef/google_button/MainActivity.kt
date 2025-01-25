package com.jubayer_ahamad_tayef.google_button

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jubayer_ahamad_tayef.google_button.ui.theme.Google_ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Google_ButtonTheme {
                GoogleButton()
            }
        }
    }
}

@Composable
fun GoogleButton() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), contentAlignment = Alignment.Center
    ) {
        GoogleButton(onClicked = { Log.d("onClicked", "Clicked!") })
    }
}

@Preview
@Composable
fun Google_ButtonPreview() {
    GoogleButton()
}