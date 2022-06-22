package jersey_quickstart.pokedex.service;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Pokemon getPokemon(@PathParam("id") String num) {
		Pokemon pokemon = null;

		for (Pokemon poke : pokemonRepository.getAll()) {
			if (poke.getNum().toLowerCase().equals(num.toLowerCase())) {
				pokemon = poke;
				return pokemon;
			}
		}

		throw new WebApplicationException(404);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pokemon> getPokemons() {
		return pokemonRepository.getAll();
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

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response putPokemon(@PathParam("id") String num, Pokemon pokemon) {
		Pokemon poke = pokemonRepository.get(Integer.parseInt(num));
		if (poke == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		try {
			pokemon.setNum(num);
			pokemonRepository.Edit(pokemon);
			return Response.status(Response.Status.OK).entity(pokemon).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePokemon(@PathParam("id") int id) {
		Pokemon poke = pokemonRepository.get(id);
		if (poke == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		try {
			pokemonRepository.delete(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
}
