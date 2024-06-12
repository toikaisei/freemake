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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
                        List1()
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
            text = "%,d".format(count),
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FreeMakeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column (modifier = Modifier.padding(innerPadding)) {
                Counter()
                TimeNow()
                List1()
            }

        }

    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeNow() {
    Row() {

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val formatted = current.format(formatter)

        Text(formatted)
        Text(
            text = "コメント"
        )
        Button(
            onClick = { "" }
        ) {
            Text(text = "追加")
        }
    }
}
@Composable
fun List1() {
    Row() {
        val fruits = listOf("Apple", "Orange", "Grape", "Peach", "Strawberry")
        val checked = remember { mutableStateOf(true) }

        Checkbox(
            modifier = Modifier
                .size(24.dp),
            checked = checked.value,
            onCheckedChange = { checked.value = it },
        )
        LazyColumn {
            items(fruits) { fruit ->
                Text(text = "This is $fruit")
            }
        }

    }

}
