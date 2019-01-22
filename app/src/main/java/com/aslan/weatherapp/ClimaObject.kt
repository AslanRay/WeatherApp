package com.aslan.weatherapp

object ClimaObject {
    data class Ciudad(val q:String, val weather:ArrayList<Weather>, val main:Main)

    data class Main(val temp: Double)

    data class Weather(val description:String)
}