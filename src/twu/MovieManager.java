package twu;

import java.util.Map;
import java.util.TreeMap;

public class MovieManager {

    private Map<Integer, Movie> movieList = new TreeMap<Integer, Movie>();

    public MovieManager(){
        loadMovieCollection();
    }

    public String viewAllMovies() {
        String booksDisplay = "Movie name  Director  Rating\n" ;
        for (Map.Entry<Integer,Movie> entry : movieList.entrySet()) {
            booksDisplay += entry.getValue().toString()+ "\n";
        }
        return booksDisplay;
    }

    private void loadMovieCollection() {

      movieList.put(1,new Movie("Rocky", "John G. Avildsen", "10"));
      movieList.put(2,new Movie("Rocky II", "John G. Avildsen", "9"));
      movieList.put(3,new Movie("Rocky III", "John G. Avildsen", "8"));
      movieList.put(4,new Movie("Rocky IV", "John G. Avildsen", "7"));
      movieList.put(5,new Movie("Rocky V", "John G. Avildsen", "8"));
      movieList.put(6,new Movie("Drainage", "Francisco Trindade", "N/A"));
      movieList.put(7,new Movie("The Shawshank Redemption", "Frank Darabont", "10"));
      movieList.put(8,new Movie("The Godfather", "Francis Ford Coppola", "7"));
      movieList.put(9,new Movie("Inception", "Frank Darabont", "10"));
      movieList.put(10,new Movie("Pulp Fiction", "Quentin Tarantino", "6"));
      movieList.put(11,new Movie("Iron Man", "Jon Favreau", "8"));
      movieList.put(12,new Movie("Chicago", "Rob Marshall", "7"));
      movieList.put(13,new Movie("Iron Man 2", "Jon Favreau", "7"));
      movieList.put(14,new Movie("The Iron Lady", "Phyllida Lloyd", "6"));
      movieList.put(15,new Movie("Pretty Woman", "Garry Marshall", "7"));
    }
}
