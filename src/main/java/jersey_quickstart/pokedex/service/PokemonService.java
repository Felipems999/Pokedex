package jersey_quickstart.pokedex.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jersey_quickstart.pokedex.entity.Pokemon;
import jersey_quickstart.pokedex.repository.PokemonRepository;

@Path("/pokemon")
public class PokemonService {
	private PokemonRepository pokemonRepositoy = new PokemonRepository();

	@GET
	@Path("{num}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pokemon getPokemon(@PathParam("num") String num) {
		Pokemon pokemon = null;

		for (Pokemon poke : pokemonRepositoy.getAll()) {
			if (poke.getNum().toLowerCase().equals(num.toLowerCase())) {
				pokemon = poke;
				return pokemon;
			}
		}

		throw new WebApplicationException(404);
	}

}
