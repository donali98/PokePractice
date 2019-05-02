package com.example.pokepractice.utils.network

import com.example.pokepractice.models.pokemon.Pokemon
import com.example.pokepractice.models.pokemon.PokemonInfo

interface NetworkHelper {
    fun onSuccessListRequest(pokemonList: List<PokemonInfo>)
    fun onErrorListRequest(t:Throwable)
    fun onSuccessRequest(pokemon:Pokemon)
    fun onErrorRequest(t:Throwable)
}