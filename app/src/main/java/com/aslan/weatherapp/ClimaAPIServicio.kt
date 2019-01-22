package com.aslan.weatherapp

import retrofit2.http.GET
import retrofit2.http.Query

interface ClimaAPIServicio {
    @GET("/data/2.5/weather")
    fun obtenerClimaPorCiudad(
        @Query("q") q:String,
        @Query("units") units:String,
        @Query("lang") lang:String,
        @Query("appid") appid:String):retrofit2.Call<ClimaObject.Ciudad>


}