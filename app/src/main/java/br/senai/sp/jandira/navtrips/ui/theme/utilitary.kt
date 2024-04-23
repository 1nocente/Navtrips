package br.senai.sp.jandira.navtrips.ui.theme

import java.time.LocalDate

fun simplificarData(DataExtenso: LocalDate): String{
    val dia = "${DataExtenso.dayOfMonth}"
    val mes = "${DataExtenso.month}".substring(0 .. 2)
    return "$dia - $mes"
}