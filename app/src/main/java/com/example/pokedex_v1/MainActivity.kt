package com.example.pokedex_v1

import android.adservices.ondevicepersonalization.KeyValueStore
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //pega o componente recyclerview
        val rvPokemons = findViewById<RecyclerView>(R.id.rvPokemon)
        rvPokemons.layoutManager = LinearLayoutManager(this)

        //pega a lista de mocks de pokemons
        val pokemons = PokemonRepository.getPokemons()

        //Entrega a lista de Pokémon para o Adapter, que pega os dados e monta a interface visual de cada item.
        rvPokemons.adapter = PokemonAdapter(pokemons) { pokemonClicado ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("POKEMON_ID", pokemonClicado.id)
            }
            startActivity(intent)
        }
    }
}

// Adapter para a lista principal
class PokemonAdapter(
    private val pokemonList: List<Pokemon>,
    private val onItemClick: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    //Mapeia e guarda as referências dos componentes visuais do XML
    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPokemon: ImageView = view.findViewById(R.id.img)
        val txtNumber: TextView = view.findViewById(R.id.number)
        val txtName: TextView = view.findViewById(R.id.name)
        val txtType: TextView = view.findViewById(R.id.type)
    }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pokemon, parent, false)
            return PokemonViewHolder(view)
        }

        //Pega os dados do Pokémon e preenche os campos do card.
        override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
            val pokemon = pokemonList[position]

            holder.txtNumber.id = pokemon.id
            holder.txtName.text = pokemon.name
            holder.txtType.text = pokemon.type
            holder.imgPokemon.setImageResource(pokemon.imageRes)

            holder.itemView.setOnClickListener {
                onItemClick(pokemon)
            }
        }


    //Informa ao Android quantas linhas/itens a lista possui no total.
    override fun getItemCount(): Int = pokemonList.size
}