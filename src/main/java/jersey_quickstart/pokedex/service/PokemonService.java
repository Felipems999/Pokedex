package jersey_quickstart.pokedex.service;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jersey_quickstart.pokedex.entity.Pokemon;
import jersey_quickstart.pokedex.repository.PokemonRepository;

@Path("/pokemon")
public class PokemonService {
	private PokemonRepository pokemonRepository = new PokemonRepository();

	@GET
	@Path("{num}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pokemon getPokemon(@PathParam("num") String num) {
		Pokemon pokemon = null;

		for (Pokemon poke : pokemonRepository.getAll()) {
			if (poke.getNum().toLowerCase().equals(num.toLowerCase())) {
				pokemon = poke;
				return pokemon;
			}
		}

		throw new WebApplicationException(404);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postPokemon(Pokemon pokemon) {

		try {
			return Response.status(Response.Status.CREATED).entity(pokemon).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}

}
