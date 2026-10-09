package com.example.pokedex_v1

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detalhes do Pokémon"

        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltar)

        // Fecha a Activity atual e retorna à tela anterior
        btnVoltar.setOnClickListener {
            finish()
        }

        // 1. Pega o ID enviado pela MainActivity
        val pokemonId = intent.getIntExtra("POKEMON_ID", -1)

        // 2. Busca o Pokémon pelo ID na lista de Mocks
        val pokemon = PokemonRepository.getPokemonById(pokemonId)

        // 3. Se encontrou o Pokémon, coloca os dados na tela
        if (pokemon != null) {
            val imgPokemon = findViewById<ImageView>(R.id.imgDetailPokemon)
            val txtName = findViewById<TextView>(R.id.txtDetailName)
            val txtType = findViewById<TextView>(R.id.txtDetailType)
            val containerEvolutions = findViewById<LinearLayout>(R.id.containerEvolutions)
            val txtMovesList = findViewById<TextView>(R.id.txtMovesList)

            // Preenche dados básicos
            imgPokemon.setImageResource(pokemon.imageRes)
            txtName.text = pokemon.name + " #" + pokemon.id
            txtType.text = "Tipo: " + pokemon.type

            // Limpa o container antes de adicionar
            containerEvolutions.removeAllViews()

            // Passa por cada evolução para desenhar a foto + nome + nível lado a lado
            for (evolucao in pokemon.evolutions) {

                // 1. Cria um bloco vertical para segurar a foto e os textos desta evolução
                val itemLayout = LinearLayout(this).apply {
                    orientation = LinearLayout.VERTICAL
                    gravity = Gravity.CENTER
                    setPadding(16, 0, 16, 0)
                }

                // 2. Cria a imagem da evolução
                val imgEvolucao = ImageView(this).apply {
                    layoutParams = LinearLayout.LayoutParams(160, 160) // Tamanho da imagem (160x160 px)
                    setImageResource(evolucao.imageRes)
                }

                // 3. Cria o texto com o Nome
                val txtNomeEvolucao = TextView(this).apply {
                    text = evolucao.pokemonName
                    textSize = 14f
                    gravity = Gravity.CENTER
                    setTextColor(android.graphics.Color.BLACK)
                }

                // 4. Cria o texto com o Requisito (ex: Nível 16)
                val txtRequisito = TextView(this).apply {
                    text = evolucao.requirement
                    textSize = 12f
                    gravity = Gravity.CENTER
                    setTextColor(android.graphics.Color.GRAY)
                }

                // Adiciona os componentes dentro do bloco individual
                itemLayout.addView(imgEvolucao)
                itemLayout.addView(txtNomeEvolucao)
                itemLayout.addView(txtRequisito)

                // Adiciona o bloco individual na caixa principal na tela
                containerEvolutions.addView(itemLayout)
            }

            // Preenche a lista de Ataques em texto
            var textoAtaques = ""
            for (ataque in pokemon.moves) {
                textoAtaques = textoAtaques + "• " + ataque + "\n"
            }
            txtMovesList.text = textoAtaques
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish() // Fecha a DetailActivity e volta para a MainActivity
        return true
    }

}