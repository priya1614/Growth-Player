package com.example.growth_player

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.growth_player.ui.theme.GrowthPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayRadioButton()
        }
    }
}

@Composable
fun DisplayRadioButton() {
    val cities = listOf("Chennai", "Mumbai", "Pune")
    val (selected, onOptionSelected) = remember {
        mutableStateOf(cities[0])
    }
    Column(Modifier.padding(4.dp)) {
        cities.forEach { text ->
            Row(modifier = Modifier.padding(4.dp)) {
                RadioButton(selected = selected == text, onClick = {
                    onOptionSelected(text)
                })
               Text(text = text, Modifier.clickable { onOptionSelected(text) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DisplayRadioButton()
}