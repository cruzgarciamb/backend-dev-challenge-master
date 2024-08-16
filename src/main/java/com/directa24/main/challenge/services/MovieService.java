package com.directa24.main.challenge.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.directa24.main.challenge.clients.DirectaMoviesClient;
import com.directa24.main.challenge.models.dto.MovieDTO;
import com.directa24.main.challenge.models.dto.MoviesResponseDTO;

public class MovieService {

	/**
	 * Load movies data from DirectaMovies
	 * @return Returns the list of MoviesDTO
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public List<MovieDTO> getMovies() throws IOException, InterruptedException {
		DirectaMoviesClient client = new DirectaMoviesClient();
		MoviesResponseDTO response = client.doGetRequest(1);
		List<MovieDTO> movies = new ArrayList<MovieDTO>();
		movies.addAll(response.getData());
		while(response.getPage() <= response.getTotalPages()) {
			   response = client.doGetRequest(response.getPage() + 1);
			   movies.addAll(response.getData());
		}
		return movies;
	}
}
