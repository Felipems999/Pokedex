package jersey_quickstart.pokedex.service;

import java.util.ArrayList;
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
	@Path("{num}")
	public Pokemon getPokemon(@PathParam("num") String num) {
		Pokemon pokemon = null;
		int id = Integer.parseInt(num);

		for (Pokemon poke : pokemonRepository.getAll()) {
			if (poke.getId() == id) {
				pokemon = poke;
				return pokemon;
			}
		}

		throw new WebApplicationException(404);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{type}")
	public List<Pokemon> getPokemonPorTipo(@PathParam("type") String type) {
		List<Pokemon> listaTipo = new ArrayList<>();

		for (Pokemon poke : pokemonRepository.getAll()) {
			if (poke.getType().contains(type)) {
				listaTipo.add(poke);
			}
		}

		return listaTipo;
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
	@Path("{num}")
	public Response putPokemon(@PathParam("num") String num, Pokemon pokemon) {
		int id = Integer.parseInt(num);

		Pokemon poke = pokemonRepository.get(id);
		if (poke == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		try {
			pokemon.setId(id);
			pokemonRepository.Edit(pokemon);
			return Response.status(Response.Status.OK).entity(pokemon).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}

	@DELETE
	@Path("{num}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePokemon(@PathParam("num") String num) {
		int id = Integer.parseInt(num);
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
