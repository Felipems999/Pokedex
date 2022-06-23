package jersey_quickstart.pokedex.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jersey_quickstart.pokedex.entity.Pokemon;

public class PokemonRepository {
	private HashMap<Integer, Pokemon> pokedex = new HashMap<>();

	public List<Pokemon> getAll() {
		return new ArrayList<Pokemon>(this.pokedex.values());
	}

	public Pokemon get(int id) {
		return this.pokedex.get(id);
	}

	public void add(Pokemon pokemon) {
		if (pokemon.getId() == 0) {
			pokemon.setId(generateId(this.pokedex.size() + 1));
		}

		this.pokedex.put(pokemon.getId(), pokemon);
	}

	public void Edit(Pokemon pokemon) {
		this.pokedex.remove(pokemon.getId());
		this.pokedex.put(pokemon.getId(), pokemon);
	}

	public void delete(int id) {
		this.pokedex.remove(id);
	}

	private int generateId(int verif) {
		if (this.pokedex.containsKey(verif))
			return generateId(verif + 1);

		return verif;
	}

}
