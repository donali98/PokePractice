package com.example.pokepractice.utils.network

import com.example.pokepractice.models.pokemon.Pokemon
import com.example.pokepractice.models.pokemon.PokemonInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network (val helperMethods:NetworkHelper){
    val BASE_URL = "https://pokeapi.co/api/v2/"

    fun makeListRequest(){
        val retro = this.getRetrofitObject()
        val call = retro.getResponse(20,0)
        call.enqueue(object:Callback<PokemonInfoResponse>{
            override fun onFailure(call: Call<PokemonInfoResponse>, t: Throwable) {
                helperMethods.onErrorListRequest(t)
            }

            override fun onResponse(call: Call<PokemonInfoResponse>, response: Response<PokemonInfoResponse>) {
                val requestResponse = response.body()!!
                val list = requestResponse.results
                helperMethods.onSuccessListRequest(list)
            }

        })
    }
    fun makeObjectRequest(id:Int){
        val retro = this.getRetrofitObject()
        val call = retro.getPokemonResponse(id)
        call.enqueue(object:Callback<Pokemon>{
            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                helperMethods.onErrorRequest(t)
            }

            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                helperMethods.onSuccessRequest(response.body()!!)
            }

        })
    }


    fun getRetrofitObject(): Api {
        val retrofit =  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        .build()
        return retrofit.create(Api::class.java)
    }
}