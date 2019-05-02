package com.example.pokepractice


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokepractice.models.pokemon.Pokemon
import com.example.pokepractice.models.pokemon.PokemonInfo
import com.example.pokepractice.models.pokemon.PokemonInfoResponse
import com.example.pokepractice.utils.network.Names
import com.example.pokepractice.utils.network.Network
import com.example.pokepractice.utils.network.NetworkHelper
import retrofit2.Call
import java.net.URI


class PokemonListFragment : Fragment(),NetworkHelper{

    val network: Network = Network(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)
        network.makeListRequest()
        return view
    }

    override fun onSuccessListRequest(pokemonList: List<PokemonInfo>) {
        Log.d(Names.CUSTOM,pokemonList.get(0).name)
        pokemonList.forEach {
            val url = URI(it.url)
            val segments = url.path.split("/")
            val pokemonId = segments[segments.size - 2].toInt()
            network.makeObjectRequest(pokemonId)
        }
    }

    override fun onErrorListRequest(t: Throwable) {
        Log.e(Names.CUSTOM,t.message)
    }


    override fun onSuccessRequest(pokemon: Pokemon) {

    }
    override fun onErrorRequest(t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
