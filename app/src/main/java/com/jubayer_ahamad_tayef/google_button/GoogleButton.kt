package com.jubayer_ahamad_tayef.google_button

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GoogleButton(
    text: String = "Sign Up with Google",
    textWhenClicked: String = "Creating account...",
    icon: Painter = painterResource(id = R.drawable.ic_google),
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    shape: CornerBasedShape = RoundedCornerShape(4.dp),
    borderColor: Color = Color.LightGray,
    circularIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    onClicked: () -> Unit
) {

    var clicked by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier
        .background(shape = shape, color = backgroundColor)
        .border(width = 1.dp, color = borderColor, shape = shape)
        .clickable { clicked = !clicked }
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 300, easing = LinearOutSlowInEasing
            )
        )
        .padding(start = 12.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Icon(painter = icon, contentDescription = null, tint = Color.Unspecified)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = if (clicked) textWhenClicked else text)
        if (clicked) {
            Spacer(modifier = Modifier.width(16.dp))
            CircularProgressIndicator(
                modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = circularIndicatorColor
            )
            onClicked()
        }
    }
}

@Preview
@Composable
fun GoogleButtonPreview() {
    GoogleButton(onClicked = { Log.d("onClicked", "Clicked!") })
}