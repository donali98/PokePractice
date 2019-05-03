package com.example.pokepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokepractice.utils.network.FragmentComunication

class MainActivity : AppCompatActivity(),FragmentComunication {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pokemonListFragment =PokemonListFragment()
        supportFragmentManager.beginTransaction().add(R.id.fl_pokemon_list,pokemonListFragment).commit()
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(this)
    }
}
