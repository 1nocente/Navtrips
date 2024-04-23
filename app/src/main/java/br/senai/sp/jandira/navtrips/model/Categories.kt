package br.senai.sp.jandira.navtrips.model


import androidx.compose.ui.graphics.painter.Painter
import java.time.LocalDate

data class Categories(
    var id:Int = 0,
    var nome:String = "",
    var imagem: Painter? = null
)
