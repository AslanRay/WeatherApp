package com.aslan.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val network = ClimaNetworkClient(applicationContext)
        val ciudad = "Tijuana"
        val call = network.obtenerClimaPorCiudad(ciudad)

        call.enqueue(object:Callback<ClimaObject.Ciudad>{
            override fun onFailure(call: Call<ClimaObject.Ciudad>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ClimaObject.Ciudad>, response: Response<ClimaObject.Ciudad>) {

                val clima: ClimaObject.Ciudad?= response.body()
                val name = ciudad
                val temp = clima?.main?.temp
                val description = clima?.weather?.get(0)?.description

                println("temp: $temp")
                //Mostrar los datos
                tvCiudad.text = name
                tvStatus.text = description
                tvTemperatura.text = temp.toString()+"°"
            }

        })
    }
}
