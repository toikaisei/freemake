package com.example.freemake

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.freemake.ui.theme.FreeMakeTheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FreeMakeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (modifier = Modifier.padding(innerPadding)) {
                        Counter()
                        TimeNow()
                    }

                }

            }
        }
    }
}

@Composable
fun Counter() {

    Row() {
        Text(
            text = "数量",
        )
        var count by remember { mutableStateOf(0) }
        Text(
            text = "$count",
        )
        Button(
            onClick = { count++ }
        ) {
            Text(text = "＋")
        }
        Button(
            onClick = { count-- }
        ) {
            Text(text = "ー")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FreeMakeTheme {
        Counter()
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeNow() {
    val dateAndtime: LocalDateTime = LocalDateTime.now()
    val onlyDate: LocalDate = LocalDate.now()

    Text("Current date and time: $dateAndtime")
    Text("Current date: $onlyDate")
}
