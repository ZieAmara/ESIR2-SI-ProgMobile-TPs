package com.example.datastorage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.datastorage.ui.theme.DataStorageTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // déclaration des variables
        val context = applicationContext
        val filename = "tape_traoré"

        super.onCreate(savedInstanceState)
        setContent {
            DataStorageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("${context.filesDir} ")
                }
            }
        }

        // créer un fichier dans l'espace de stockage spécifique de l'application
        val file = File(this.getExternalFilesDir(null), filename)
        file.createNewFile()

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DataStorageTheme {
        Greeting("Android")
    }
}