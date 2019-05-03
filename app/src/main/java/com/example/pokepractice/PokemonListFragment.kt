package com.example.pokepractice


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokepractice.models.pokemon.Pokemon
import com.example.pokepractice.models.pokemon.PokemonAdapter
import com.example.pokepractice.models.pokemon.PokemonInfo
import com.example.pokepractice.models.pokemon.PokemonInfoResponse
import com.example.pokepractice.utils.network.FragmentComunication
import com.example.pokepractice.utils.network.Names
import com.example.pokepractice.utils.network.Network
import com.example.pokepractice.utils.network.NetworkHelper
import retrofit2.Call
import java.net.URI


class PokemonListFragment : Fragment(),NetworkHelper{

    lateinit var recyclerView:RecyclerView
    lateinit var fragmentComunication:FragmentComunication
    lateinit var customLayoutManager:RecyclerView.LayoutManager
    lateinit var pokemonAdapter: PokemonAdapter
    var listSize = 0

    var pokemonList:ArrayList<Pokemon> = ArrayList()
    val network: Network = Network(this)


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        fragmentComunication = context as FragmentComunication
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)
        network.makeListRequest()
        recyclerView = view.findViewById(R.id.rv_pokemon_list)

        return view
    }

    override fun onSuccessListRequest(pokemonList: List<PokemonInfo>) {
        Log.d(Names.CUSTOM,pokemonList.get(0).name)
        listSize = pokemonList.size
        Log.d(Names.CUSTOM,listSize.toString())
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
        pokemonList.add(pokemon)
        listSize --

        if(listSize == 0){
            val sortedList = pokemonList.sortedWith(compareBy({it.id}))
            customLayoutManager = fragmentComunication.getLayoutManager()
            pokemonAdapter =  PokemonAdapter(sortedList)
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = customLayoutManager
                adapter = pokemonAdapter
            }
        }


    }
    override fun onErrorRequest(t: Throwable) {

    }

}
