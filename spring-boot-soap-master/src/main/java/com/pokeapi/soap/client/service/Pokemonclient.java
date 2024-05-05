package com.pokeapi.soap.client.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author agarciad0705
 *
 */
@Slf4j
@Service
public class Pokemonclient {

	public String getPokemonData(String nombre, String element) {
		try {
			log.info(">>Send getPokemonData : https://pokeapi.co/api/v2/pokemon/" + nombre);
			URLConnection connection = new URL("https://pokeapi.co/api/v2/pokemon/" + nombre).openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();
			BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = r.readLine()) != null) {
				sb.append(line);
			}
			log.info("Response > " + sb.toString());

			JSONObject response = new JSONObject(sb.toString());

			if (response.get(element) instanceof String) {
				return response.getString(element) + "";
			}
			if (response.get(element) instanceof Integer) {
				return response.getLong(element) + "";
			}
			if (response.get(element) instanceof JSONObject) {
				return response.getJSONObject(element) + "";
			}
			if (response.get(element) instanceof JSONArray) {
				return response.getJSONArray(element) + "";
			}
			return response.toString();
		} catch (FileNotFoundException e) {
			log.error("ERROR: pokemon no encontrado " + nombre + "  errorMessage:" + e.getMessage());
			return null;
		} catch (Exception e) {
			log.error("ERROR:" + e.getMessage(), e);
			return null;
		}
	}

}
