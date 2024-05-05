package com.pokeapi.soap.soap.endpoints;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.pokeapi.soap.client.service.Pokemonclient;
import com.pokeapi.soap.data.TransactionService;
import com.pokeapi.soap.data.Trx;

import lombok.extern.slf4j.Slf4j;
import soap.pokeapi.connection.AbilitiesRequest;
import soap.pokeapi.connection.AbilitiesResponse;
import soap.pokeapi.connection.BaseExperienceRequest;
import soap.pokeapi.connection.BaseExperienceResponse;
import soap.pokeapi.connection.HeldItemsRequest;
import soap.pokeapi.connection.HeldItemsResponse;
import soap.pokeapi.connection.IdRequest;
import soap.pokeapi.connection.IdResponse;
import soap.pokeapi.connection.LocationAreaEncountersRequest;
import soap.pokeapi.connection.LocationAreaEncountersResponse;
import soap.pokeapi.connection.NameRequest;
import soap.pokeapi.connection.NameResponse;
import soap.pokeapi.connection.PokemonInfo;

/**
 * 
 * @author agarciad0705
 *
 */
@Slf4j
@Endpoint
public class PokemonEndpoint {

	@Autowired
	private TransactionService transactionService;

	private HttpServletRequest httpServletRequest;

	@Autowired
	public void setRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
	}

	private static final String NAMESPACE_URI = "http://connection.pokeapi.soap";

	public PokemonInfo getPokemonInfo(String pokemon, String element) {
		log.info(element);

		AbilitiesResponse response = new AbilitiesResponse();
		Pokemonclient pc = new Pokemonclient();
		try {
			PokemonInfo pokemonInfo = new PokemonInfo();
			pokemonInfo.setProperty(element);
			String pokemonData = pc.getPokemonData(pokemon, element);
			if (pokemonData == null) {
				pokemonInfo.setData("POKEMON NOT FOUND");
			} else {
				log.info("INFO: Get info {} PokemonData:{}", element, pokemonData);
				pokemonInfo.setData(pokemonData);
			}
			response.setPokemonInfo(pokemonInfo);

			return pokemonInfo;
		} catch (Exception e) {
			log.error("Error:", e);
			return null;
		} finally {
			try {
				Trx trx = new Trx();
				log.info("END Send " + this.httpServletRequest.getRemoteAddr());
				trx.setIp(this.httpServletRequest.getRemoteAddr() + "");
				trx.setDate(LocalDate.now());
				trx.setAction(element);
				transactionService.save(trx);
			} catch (Exception e) {
				log.error("Error:", e);
			}
			log.info("END Send " + this.httpServletRequest.getRemoteAddr());
		}
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "abilitiesRequest")
	@ResponsePayload
	public AbilitiesResponse getAbilities(@RequestPayload AbilitiesRequest request) {
		log.info("abilities");
		AbilitiesResponse response = new AbilitiesResponse();
		response.setPokemonInfo(getPokemonInfo(request.getPokemon(), "abilities"));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "base_experienceRequest")
	@ResponsePayload
	public BaseExperienceResponse getBaseExperience(@RequestPayload BaseExperienceRequest request) {
		log.info("base_experience");
		BaseExperienceResponse response = new BaseExperienceResponse();
		response.setPokemonInfo(getPokemonInfo(request.getPokemon(), "base_experience"));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "held_itemsRequest")
	@ResponsePayload
	public HeldItemsResponse getheld_itemsExperience(@RequestPayload HeldItemsRequest request) {
		log.info("held_items");

		HeldItemsResponse response = new HeldItemsResponse();
		response.setPokemonInfo(getPokemonInfo(request.getPokemon(), "held_items"));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "idRequest")
	@ResponsePayload
	public IdResponse getBaseExperience(@RequestPayload IdRequest request) {
		log.info("id");
		IdResponse response = new IdResponse();
		response.setPokemonInfo(getPokemonInfo(request.getPokemon(), "id"));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "nameRequest")
	@ResponsePayload
	public NameResponse getBaseExperience(@RequestPayload NameRequest request) {
		log.info("name");
		NameResponse response = new NameResponse();
		response.setPokemonInfo(getPokemonInfo(request.getPokemon(), "name"));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "location_area_encountersRequest")
	@ResponsePayload
	public LocationAreaEncountersResponse getBaseExperience(@RequestPayload LocationAreaEncountersRequest request) {
		log.info("location_area_encounters");
		LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();
		response.setPokemonInfo(getPokemonInfo(request.getPokemon(), "location_area_encounters"));
		return response;
	}

}
