package com.example.pokepractice.utils.network

import com.example.pokepractice.models.pokemon.Pokemon
import com.example.pokepractice.models.pokemon.PokemonInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("pokemon")
    fun getResponse(@Query("limit")limit:Int,@Query("offset")offset:Int): Call<PokemonInfoResponse>
    @GET("pokemon/{id}")
    fun getPokemonResponse(@Path("id")id:Int):Call<Pokemon>
}