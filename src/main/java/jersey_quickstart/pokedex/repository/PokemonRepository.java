package jersey_quickstart.pokedex.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jersey_quickstart.pokedex.entity.Pokemon;

public class PokemonRepository {
	private final static HashMap<Integer, Pokemon> pokemons = new HashMap<>();

	public List<Pokemon> getAll() {
		return new ArrayList<Pokemon>(pokemons.values());
	}

	public Pokemon get(int id) {
		return this.pokemons.get(id);
	}

	public void add(Pokemon pokemon) {
		if (pokemon.getId() == 0) {
			pokemon.setId(generateId(this.pokemons.size() + 1));
		}

		this.pokemons.put(pokemon.getId(), pokemon);
	}

	public void Edit(Pokemon pokemon) {
		this.pokemons.remove(pokemon.getId());
		this.pokemons.put(pokemon.getId(), pokemon);
	}

	public void delete(int id) {
		this.pokemons.remove(id);
	}

	private int generateId(int verif) {
		if (this.pokemons.containsKey(verif))
			return generateId(verif + 1);

		return verif;
	}

}
