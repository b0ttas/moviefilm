package com.bottas.moviefilm;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestPostTest {
	@Test
	public void test() throws UnirestException {
		String apiKey = System.getenv("API_KEY");;
		//Person Query
		Unirest.setTimeouts(0, 0);
		HttpResponse<JsonNode> response = Unirest.get("https://api.themoviedb.org/3/search/person?api_key="+apiKey+"&query=quentin")
		  .asJson();
		
		// retrieve the parsed JSONObject from the response
		JSONObject myObj = response.getBody().getObject();

	}
}
