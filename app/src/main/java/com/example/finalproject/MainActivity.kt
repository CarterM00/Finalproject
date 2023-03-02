package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalproject.ui.theme.FinalprojectTheme
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalprojectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FourSquareButtons()
                }
                }
            }
        }
    }

@Composable
fun FourSquareButtons() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SquareButton("Component 1")  { context.startActivity(Intent(context, MainActivity1::class.java)) }
                SquareButton("Component 2") { context.startActivity(Intent(context, MainActivity2::class.java))  }
                SquareButton("Component 3") { context.startActivity(Intent(context, MainActivity3::class.java))  }
                SquareButton("Component 4") { context.startActivity(Intent(context, MainActivity4::class.java))  }
            }
        }
    }
}

@Composable
fun SquareButton(label: String, onClick: () -> Unit) {
    val isButtonClicked = remember { mutableStateOf(false) }

    Button(
        onClick = {
            isButtonClicked.value = !isButtonClicked.value
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(23.dp)
            .height(150.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isButtonClicked.value) MaterialTheme.colors.secondary else MaterialTheme.colors.primary
        )
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.button,
            fontSize = 30.sp
            )
    }
}