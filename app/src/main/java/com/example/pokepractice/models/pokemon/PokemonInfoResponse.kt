package com.example.pokepractice.models.pokemon

import com.google.gson.annotations.SerializedName

class PokemonInfoResponse(@SerializedName("results")val results:List<PokemonInfo>) {
}