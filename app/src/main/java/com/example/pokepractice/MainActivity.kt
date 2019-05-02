package com.example.pokepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pokemonListFragment =PokemonListFragment()
        supportFragmentManager.beginTransaction().add(R.id.fl_pokemon_list,pokemonListFragment).commit()
    }
}
