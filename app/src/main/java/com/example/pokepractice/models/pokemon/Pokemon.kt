package com.example.pokepractice.models.pokemon

import com.google.gson.annotations.SerializedName

class Pokemon(@SerializedName("abilities") var abilities:List<Ability>) {

}