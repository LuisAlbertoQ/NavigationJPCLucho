package com.example.nabigationjpclucho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nabigationjpclucho.ui.presentation.component.MyAppDrawer
import com.example.nabigationjpclucho.ui.theme.LightColorScheme
import com.example.nabigationjpclucho.ui.theme.NabigationJPCLuchoTheme
import com.example.nabigationjpclucho.ui.theme.ThemeType
import com.example.nabigationjpclucho.ui.theme.darkGreenScheme
import com.example.nabigationjpclucho.ui.theme.darkRedScheme
import com.example.nabigationjpclucho.ui.theme.lightGreenScheme
import com.example.nabigationjpclucho.ui.theme.lightRedScheme
import com.example.nabigationjpclucho.utils.conttexto
import com.example.nabigationjpclucho.utils.isNight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeType = remember { mutableStateOf(ThemeType.RED) }
            val darkThemex = isNight()
            val darkTheme = remember { mutableStateOf(darkThemex) }
            val colorScheme = when (themeType.value) {
                ThemeType.GREEN -> {if (darkTheme.value) darkGreenScheme else
                    lightGreenScheme}
                ThemeType.RED -> {if (darkTheme.value) darkRedScheme else
                    lightRedScheme}
                else -> {lightRedScheme}
            }
            conttexto.CONTEXTO_APPX = this

            NabigationJPCLuchoTheme(colorScheme = colorScheme) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                MyAppDrawer(darkMode = darkTheme, themeType = themeType)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NabigationJPCLuchoTheme(colorScheme = lightRedScheme) {
        Greeting("Android")
    }
}