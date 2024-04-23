package br.senai.sp.jandira.navtrips.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BeachAccess
import androidx.compose.material.icons.filled.Landscape
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Snowboarding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.navtrips.R
import br.senai.sp.jandira.navtrips.ui.theme.NavTripsTheme
import br.senai.sp.jandira.navtrips.ui.theme.simplificarData
import br.senai.sp.jandira.viagem.repository.ViagemRepository

@Composable
fun telaHome(controleDeNavegacao: NavHostController) {

    val viagens = ViagemRepository().listarTodasAsViagens(LocalContext.current)

    NavTripsTheme {

        Surface {

            Column {

                Card(
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {

                    Box(modifier = Modifier.fillMaxSize()) {


                        Image(
                            modifier = Modifier
                                .fillMaxSize(),
                            painter = painterResource(id = R.drawable.paris),
                            contentDescription = "Imagem de fundo",
                            contentScale = ContentScale.Crop

                        )
                        Column {

                            Image(
                                painter = painterResource(id = R.drawable.account),
                                contentDescription = "Account",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(110.dp)
                                    .padding(16.dp),
                                alignment = Alignment.TopEnd
                            )
                            Text(text = "Susanna Hoffs", fontSize = 16.sp, color = Color.White, modifier = Modifier
                                .padding(start = 270.dp)
                                .shadow(16.dp, shape = CircleShape, clip = true))


                            Column {


                                Row(
                                    modifier = Modifier
                                        .padding(start = 10.dp)
                                ) {

                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "emogi",
                                        tint = Color.White
                                    )

                                    Text(
                                        text = "You're in Paris",
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                }

                                Text(text = "My Trips",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 26.sp,
                                    modifier = Modifier.padding(start = 16.dp))
                            }

                        }


                    }





                }

                Text(text = "Categories", fontSize = 18.sp)

                LazyRow{
                    item(1){
                        Card (
                            modifier = Modifier
                                .height(90.dp)
                                .width(130.dp)
                                .padding(10.dp),
                            colors = CardDefaults.cardColors(Color.Magenta)
                        ){
                            Column {
                                Icon(imageVector = Icons.Default.Landscape, contentDescription ="Montanha",
                                    tint = Color.White, modifier = Modifier
                                        .padding(start = 40.dp, top = 10.dp))
                                Text(text = "Mountain", color = Color.White, modifier = Modifier
                                    .padding(start = 20.dp))
                            }



                        }
                        Card (
                            modifier = Modifier
                                .height(90.dp)
                                .width(130.dp)
                                .padding(10.dp),
                            colors = CardDefaults.cardColors(Color.Magenta)
                        ) {
                            Column {
                                Icon(imageVector = Icons.Default.Snowboarding, contentDescription ="Neve",
                                    tint = Color.White, modifier = Modifier
                                        .padding(start = 40.dp, top = 10.dp))
                                Text(text = "Snow", color = Color.White, modifier = Modifier
                                    .padding(start = 35.dp))
                            }

                        }
                        Card (
                            modifier = Modifier
                                .height(90.dp)
                                .width(130.dp)
                                .padding(10.dp),
                            colors = CardDefaults.cardColors(Color.Magenta)
                        ) {
                            Column {
                                Icon(imageVector = Icons.Default.BeachAccess, contentDescription ="Praia",
                                    tint = Color.White, modifier = Modifier
                                        .padding(start = 40.dp, top = 10.dp))
                                Text(text = "Beach", color = Color.White, modifier = Modifier
                                    .padding(start = 30.dp))
                            }

                        }







                    }
                }

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(380.dp)
                        .padding(start = 10.dp),
                    shape = RoundedCornerShape(32.dp),

                    placeholder = {
                        Text(text = "Search Your destiny",
                            color = Color.Gray)
                    },
                    trailingIcon = {
                        IconButton(onClick = { }) {

                            Icon(imageVector = Icons.Default.Search,
                                contentDescription = "Botão Buscar",
                                tint = Color.Gray)

                        }
                    },

                    )
                Text(text = "Past Trips", modifier = Modifier
                    .padding(15.dp))

                LazyColumn{
                    items(viagens){
                        Card (
                            modifier = Modifier
                                .height(230.dp)
                                .width(390.dp)
                                .padding(10.dp)
                                .shadow(20.dp),
                            colors = CardDefaults.cardColors(Color.White)
                        ) {
                            Column {
                                Surface {
                                    Image(painter =if (it.imagem == null)
                                        painterResource(id = R.drawable.freefire) else  it.imagem!!,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(125.dp))
                                }
                                Text(text = "${it.destino}," +
                                        " ${it.dataPartida.year}",

                                        color = Color.Magenta,
                                    modifier = Modifier
                                        .padding(start = 10.dp, top = 5.dp)
                                )
                                Text(text = it.descricao, fontSize = 12.sp, lineHeight = 10.sp, color = Color.Gray, modifier = Modifier
                                    .padding(start = 10.dp))
                                Row {


                                    Text(
                                        text = simplificarData(it.dataChegada),
                                        fontSize = 12.sp, color = Color.Magenta, modifier = Modifier
                                            .padding(start = 230.dp, top = 5.dp)
                                    )
                                    Text(text = "  -  ")
                                    Text(
                                        text = simplificarData(it.dataPartida),
                                        fontSize = 12.sp, color = Color.Magenta, modifier = Modifier
                                            .padding(start = 0.dp, top = 5.dp)
                                    )
                                }
                            }


                        }

                    }
                }

            }



        }
    }
    
}

@Preview
@Composable
fun telaHomePreview() {

    NavTripsTheme {
        Surface(modifier = Modifier
            .fillMaxSize()){

        }
    }

   // telaHome(controleDeNavegacao)

}