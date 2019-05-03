package com.example.pokepractice.models.pokemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokepractice.R

class PokemonAdapter(var pokemonList:List<Pokemon>):RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        holder.bind(pokemonList.get(position))
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        lateinit var txtName: TextView
        fun bind(pokemon:Pokemon) = with(itemView){
            txtName = findViewById(R.id.txt_name)
            txtName.text = pokemon.name
        }
    }
}