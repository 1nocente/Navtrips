package br.senai.sp.jandira.navtrips.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.navtrips.ui.theme.NavTripsTheme

@Composable
fun telaLogin(controleDeNavegacao: NavHostController) {

    var usuarioState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    var mensagemErroState = remember {
        mutableStateOf("")
    }


    NavTripsTheme {

        Surface(modifier = Modifier
            .fillMaxSize()) {



        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .height(height = 50.dp)
                    .width(width = 160.dp)
                    .background(
                        color = Color(0xFFCF06F0),
                        shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 20.dp)
                    )
                    .align(Alignment.End)
            ) {

            }

            Text(
                text = "Login",
                fontSize = 55.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFCF06F0),
                modifier = Modifier
                    .padding(top = 150.dp, start = 20.dp)
            )

            Text(
                text = "Please sign in to continue.",
                color = Color(0xFFA09C9C),
                fontSize = 19.sp,
                letterSpacing = 0.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
            )

            OutlinedTextField(value = usuarioState.value,
                onValueChange = { usuarioState.value = it },
                isError = isErrorState.value,
                label = { Text(text = "E-mail") },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 60.dp)
                    .width(350.dp)
                    .height(66.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    focusedBorderColor = Color(0xFFCF06F0)
                ),
                shape = RoundedCornerShape(15.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email, contentDescription = "",
                        tint = Color(0xFFCF06F0)
                    )
                }


            )

            OutlinedTextField(
                value = senhaState.value, onValueChange = {senhaState.value = it},
                isError = isErrorState.value,
                label = { Text(text = "Password") },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp)
                    .width(350.dp)
                    .height(66.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    focusedBorderColor = Color(0xFFCF06F0)

                ),
                shape = RoundedCornerShape(15.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock, contentDescription = "",
                        tint = Color(0xFFCF06F0)
                    )
                }


            )
            Text(text = mensagemErroState.value,
                color = Color.Red)

            Button(
                onClick = {if (usuarioState.value == "aluno" && senhaState.value == "1234") {
                    controleDeNavegacao.navigate("home")

                    //enviar para tela home
                } else {
                    isErrorState.value = true
                    mensagemErroState.value = "Usuario ou senha inválidos"
                }},
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFCF06F0)),
                modifier = (Modifier
                    .align(Alignment.End)
                    .width(width = 160.dp)
                    .height(height = 90.dp)
                    .padding(top = 30.dp, end = 20.dp)
                        )
            ) {
                Text(
                    text = "SIGN IN ->", fontSize = 19.sp, fontWeight = FontWeight.ExtraBold
                )


            }

            Row {

                Text(
                    text = "Don't have an account?",
                    color = Color(0xFFA09C9C),
                    fontSize = 15.sp,
                    letterSpacing = 0.sp,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 160.dp)
                )

                Button(onClick = {controleDeNavegacao.navigate("Sign")}, colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier.padding(top = 7.dp)) {
                    Text(
                        text = "Sign up",
                        color = Color(0xFFCF06F0),
                        fontSize = 15.sp,
                        letterSpacing = 0.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }

            }
            Column(
                modifier = Modifier
                    .height(height = 50.dp)
                    .width(width = 160.dp)
                    .offset(y = 86.dp)
                    .background(
                        color = Color(0xFFCF06F0),
                        shape = RoundedCornerShape(0.dp, 20.dp, 0.dp, 0.dp),
                    )
                    .align(Alignment.Start)
            ) {

            }
        }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun telaLoginPreview() {

    NavTripsTheme {
        Surface(modifier = Modifier
            .fillMaxSize()){

        }
    }
    //telaLogin(controleDeNavegacao)

}