package com.example.freemake

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
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
                        var count: Int = 0
                        var counter: Int = Counter(count)
                        val current = LocalDateTime.now()
                        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
                        val formatted = current.format(formatter)
                        formatted.toString()
                        Row() {
                            TimeNow(formatted)
                            Comment()
                            Addition()
                        }
                        Row() {
                            CheckableCheckbox()
                            List(formatted, counter)
                            Comment()
                            Delete()
                        }

                        Row() {
                            Clear()
                            TotalCalc()
                        }

                    }

                }

            }
        }
    }
}

@Composable
fun Counter(count: Int): Int {
    var count by remember { mutableStateOf(0) }
    Row() {
        Text(
            text = "数量",
        )
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
    return count
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FreeMakeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column (modifier = Modifier.padding(innerPadding)) {
                var count: Int = 0
                var counter:Int = Counter(count)
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
                val formatted = current.format(formatter)
                Row {
                    TimeNow(formatted)
                    Comment()
                    Addition()
                }
                Row() {
                    CheckableCheckbox()
                    List(formatted, counter)
                    Comment()
                    Delete()
                }
                Row {
                    Clear()
                    TotalCalc()
                }

            }

        }

    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeNow(formatted: String) {
    return Text(formatted)
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun List(formatted: String, count: Int) {
        val stock = listOf(formatted, count)
        LazyRow {
            items(stock) { stock ->
                    Text(text = "$stock")
            }
        }
}
@Composable
fun CheckableCheckbox() {
    val checked = remember { mutableStateOf(true) }
    Checkbox(
        modifier = Modifier
            .size(24.dp),
        checked = checked.value,
        onCheckedChange = { checked.value = it },
    )
}
@Composable
fun Clear() {
    Row() {
        Button(
            onClick = { "" }
        ) {
            Text(text = "クリア")
        }
    }

}
@Composable
fun TotalCalc() {
    Button(
        onClick = { "" }
    ) {
        Text(text = "選択された合計数量")
    }
}
@Composable
fun Delete() {
    Button(
        onClick = { "" }
    ) {
        Text(text = "削除")
    }
}
@Composable
fun Comment() {
    Text(text = "コメント")
/*    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.padding(10.dp),
            label = { Text(text = "コメント") }
        )
    }*/
}
@Composable
fun Addition() {
    Button(
        onClick = { "" }
    ) {
        Text(text = "追加")
    }
}