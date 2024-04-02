package br.senai.sp.jandira.navtrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.navtrips.screens.telaHome
import br.senai.sp.jandira.navtrips.screens.telaLogin
import br.senai.sp.jandira.navtrips.screens.telaSignUp
import br.senai.sp.jandira.navtrips.ui.theme.NavTripsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavTripsTheme {
                // A surface container using the 'background' color from the theme
                val controleDeNavegacao = rememberNavController()
                NavHost(navController = controleDeNavegacao,
                    startDestination = "login"
                ){
                    composable(route = "login"){ telaLogin(controleDeNavegacao)}
                    composable(route = "Sign"){telaSignUp(controleDeNavegacao)}
                    composable(route = "home"){ telaHome(controleDeNavegacao)}

                }
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
    NavTripsTheme {
       // telaLogin(controleDeNavegacao)
    }
}