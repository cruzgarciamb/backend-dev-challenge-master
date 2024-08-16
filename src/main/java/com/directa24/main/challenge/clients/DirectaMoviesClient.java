package com.directa24.main.challenge.clients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.directa24.main.challenge.models.dto.MoviesResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DirectaMoviesClient {
	
	private final String URL = "https://directa24-movies.wiremockapi.cloud/api/movies/search?page=";
	
	/**
	 * To execute the get method and return the response
	 * @param page
	 * @return MoviesResponse
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public MoviesResponseDTO doGetRequest(int page) throws IOException, InterruptedException {
		  
		  HttpClient client = HttpClient.newHttpClient();
		  HttpRequest request = HttpRequest.newBuilder()
				  .GET()
				  .header("accept", "application/json")
				  .uri(URI.create(URL + page))
				  .build();
		  HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	      
		  // parse Json to Object
		  ObjectMapper mapper = new ObjectMapper();
		  return mapper.readValue(response.body(), MoviesResponseDTO.class);
	}
	
}
