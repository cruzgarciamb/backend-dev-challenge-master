package com.directa24.main.challenge;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.directa24.main.challenge.services.MovieService;

public class Main {

   public static void main(String[] args) throws IOException, InterruptedException {
      List<String> directors = getDirectors(3);
      System.out.println(String.join("\n", directors));
   }

   /*
    * Complete the 'getDirectors' function below.
    *
    * The function is expected to return a List<String>.
    * The function accepts int threshold as parameter.
    *
    * URL
    * https://directa24-movies.mocklab.io/api/movies/search?page=<pageNumber>
    */
   public static List<String> getDirectors(int threshold) throws IOException, InterruptedException {
	  
	   MovieService service = new MovieService();
	  
	   List<String> directors = service.getMovies()
			  .stream()
			  .map(movie -> movie.getDirector())
			  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			  .entrySet().stream().filter(el -> el.getValue() > threshold)
			  .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
			  .map(Map.Entry::getKey).collect(Collectors.toList());
	  
	   return directors;
   }
   
   

}
