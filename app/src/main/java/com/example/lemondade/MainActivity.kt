package com.example.lemondade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemondade.ui.theme.LemondadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemondadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeWithClickableImages() {
    var state by remember{ mutableStateOf( 1 )}
    val imageResource = when(state) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val stringResourceId = when(state) {
        1 -> R.string.one
        2 -> R.string.two
        3 -> R.string.three
        else -> R.string.four
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(text = stringResource(stringResourceId), fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(imageResource),
            contentDescription = state.toString(),
            modifier = Modifier.clickable {
                state = when(state) {
                    2 -> if ((1..4).random() == 1) state+1 else state
                    else -> state+1
                }
                state %= 4
            }.border(2.dp, color = Color(105, 205, 216),
                shape = RoundedCornerShape(8.dp)
            )
        )
    }
}

@Preview()
@Composable
fun LemonadeApp() {
    LemonadeWithClickableImages()
}