package com.aslan.weatherapp

import android.content.Context
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClimaNetworkClient(val context: Context) {
    val apiKey = "7391d815a5132bd9ccddb30572d9fc56"

    fun obtenerClimaPorCiudad(ciudad:String):Call<ClimaObject.Ciudad> {
        val network = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val servicioClima = network.create(ClimaAPIServicio::class.java)
        val clima = servicioClima.obtenerClimaPorCiudad(ciudad,"metric","es",apiKey)
        return  clima
    }
}