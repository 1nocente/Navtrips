package br.senai.sp.jandira.viagem.model

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.painter.Painter
import java.time.LocalDate

data class Viagem(
    var id:Int = 0,
    var destino:String = "",
    var dataChegada:LocalDate = LocalDate.now(),
    var dataPartida:LocalDate = LocalDate.now(),
    var descricao: String = "",
    var imagem:Painter? = null
)
