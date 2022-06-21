package jersey_quickstart.pokedex.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jersey_quickstart.pokedex.entity.Pokemon;

public class PokemonRepository {
	private final static HashMap<Integer, Pokemon> pokemon = new HashMap<>();

	public List<Pokemon> getAll() {
		return new ArrayList<Pokemon>(pokemon.values());
	}

	public Pokemon get(int id) {
		return this.pokemon.get(id);
	}

	public void add(Pokemon pokemon) {
		if (pokemon.getId() == 0) {
			pokemon.setId(generateId(this.pokemon.size() + 1));
		}

		this.pokemon.put(pokemon.getId(), pokemon);
	}

	public void Edit(Pokemon pokemon) {
		this.pokemon.remove(pokemon.getId());
		this.pokemon.put(pokemon.getId(), pokemon);
	}

	private int generateId(int verif) {
		if (this.pokemon.containsKey(verif))
			return generateId(verif + 1);

		return verif;
	}

}
