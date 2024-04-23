package br.senai.sp.jandira.viagem.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.navtrips.R
import br.senai.sp.jandira.viagem.model.Viagem
import java.time.LocalDate

class ViagemRepository {

    @Composable
    fun listarTodasAsViagens(context:Context): List<Viagem>{

        //Viagem viagemLondres = new Viagem()
        val viagemLondres = Viagem()
        viagemLondres.id = 1
        viagemLondres.destino = "Londres"
        viagemLondres.descricao = "Londres, capital da Inglaterra e do Reino Unido, é uma cidade do século 21 com uma história que remonta à era romana."
        viagemLondres.dataChegada = LocalDate.of(2023, 2, 18)
        viagemLondres.dataPartida = LocalDate.of(2023, 2, 25)
        viagemLondres.imagem = painterResource(R.drawable.london)

        val viagemParis = Viagem()
        viagemParis.id = 2
        viagemParis.destino = "Paris"
        viagemParis.descricao = "Madri, a capital da Espanha, situada no centro do país, é uma cidade de avenidas elegantes e parques grandes e bem cuidados, como o Buen Retiro."
        viagemParis.dataChegada = LocalDate.of(2023, 2, 26)
        viagemParis.dataPartida = LocalDate.of(2023, 3, 1)
        viagemParis.imagem = painterResource(R.drawable.paris)

        val viagemMadrid = Viagem()
        viagemMadrid.id = 3
        viagemMadrid.destino = "Madrid"
        viagemMadrid.descricao = "Paris, a capital da França, é uma importante cidade europeia e um centro mundial de arte, moda, gastronomia e cultura."
        viagemMadrid.dataChegada = LocalDate.of(2023, 2, 1)
        viagemMadrid.dataPartida = LocalDate.of(2023, 3, 4)
        viagemMadrid.imagem = painterResource(R.drawable.porto)
        //val viagens = listOf<>()

        val viagens = listOf(viagemLondres, viagemMadrid, viagemParis)
        return viagens

    }
}