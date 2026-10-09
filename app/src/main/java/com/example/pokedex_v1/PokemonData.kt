package com.example.pokedex_v1


//data class com mocks de poekemons
data class Evolution(
    val pokemonName: String,
    val requirement: String,
    val imageRes: Int
)

data class Pokemon(
    val id: Int,
    val name: String,
    val type: String,
    val imageRes: Int,
    val moves: List<String>,
    val evolutions: List<Evolution>
)

// Repositório de dados mockados
object PokemonRepository {
    fun getPokemons(): List<Pokemon> {
        return listOf(
            Pokemon(
                id = 1,
                name = "Bulbasaur",
                type = "Planta / Veneno",
                imageRes = R.drawable.bulbasaur,
                moves = listOf("Chicote de Vinha", "Folha Navalha", "Semente do Vampiro", "Bomba de Sementes"),
                evolutions = listOf(
                    Evolution("Bulbasaur", "Forma Inicial",R.drawable.bulbasaur),
                    Evolution("Ivysaur", "Nível 16", R.drawable.ivysaur),
                    Evolution("Venusaur", "Nível 32", R.drawable.venusaur)
                )
            ),
            Pokemon(
                id = 4,
                name = "Charmander",
                type = "Fogo",
                imageRes = R.drawable.charmander,
                moves = listOf("Lança-Chamas", "Arranhão", "Garra de Metal", "Lança-Chamas"),
                evolutions = listOf(
                    Evolution("Charmander", "Forma Inicial",R.drawable.charmander),
                    Evolution("Charmeleon", "Nível 16",R.drawable.charmeleon),
                    Evolution("Charizard", "Nível 36",R.drawable.charizard)
                )
            ),
            Pokemon(
                id = 7,
                name = "Squirtle",
                type = "Água",
                imageRes = R.drawable.squirtle,
                moves = listOf("Jato de Água", "Investida", "Pistola de Água", "Raio Solar"),
                evolutions = listOf(
                    Evolution("Squirtle", "Forma Inicial",R.drawable.squirtle),
                    Evolution("Wartortle", "Nível 16", R.drawable.wartortle),
                    Evolution("Blastoise", "Nível 36",R.drawable.blastoise)
                )
            )
        )
    }
    fun getPokemonById(id: Int): Pokemon? {
        return getPokemons().find { it.id == id }
    }
}
