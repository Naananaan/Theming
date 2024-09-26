package com.example.theming

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults // Import ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color // Import Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.theming.ui.theme.ThemingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThemingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Theming() // Call Theming composable
                }
            }
        }
    }
}

@Composable
fun Theming() {
    val appModifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)

    val inputText = remember { mutableStateOf("") }
    val dummyState = remember { mutableStateOf(0) } // Trigger recompositions

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Application",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputText.value,
            onValueChange = { inputText.value = it },
            label = { Text("Enter something") },
            modifier = appModifier
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle button click */
                      dummyState.value++ },
            modifier = appModifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White // Use Color here
            )
        ) {
            Text(text = "Submit")
        }

        Log.d("ThemeCheck", "Primary Color: ${MaterialTheme.colorScheme.primary.toString()}")
    }
}

@Preview(showBackground = true)
@Composable
fun ThemingPreview() {
    ThemingTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Theming() // Preview the Theming composable
        }
    }
}
