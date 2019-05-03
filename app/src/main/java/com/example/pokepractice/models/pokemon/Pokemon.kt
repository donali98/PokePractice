package com.example.pokepractice.models.pokemon

import com.google.gson.annotations.SerializedName

class Pokemon(
        @SerializedName("id")var id:Int,
        @SerializedName("name")var name:String,
        @SerializedName("abilities") var abilities:List<Ability>
) {

}