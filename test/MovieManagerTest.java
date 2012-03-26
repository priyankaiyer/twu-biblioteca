import org.junit.Assert;
import org.junit.Test;
import twu.MovieManager;

public class MovieManagerTest extends BibliotecaTest{

    protected MovieManager movieManager = new MovieManager();

    @Test
    public void test_should_show_view_movie_menu_item(){
        String viewMovieMenuItem = "View all movies.";
        Assert.assertTrue(biblioteca.showMenuOptions().contains(viewMovieMenuItem));
    }

    @Test
    public void test_should_list_all_movies_with_name_director_ratings(){
        String allMovies =
            "Movie name  Director  Rating\n"                          +
            "Rocky John G. Avildsen 10\n"                           +
            "Rocky II John G. Avildsen 9\n"                         +
            "Rocky III John G. Avildsen 8\n"                        +
            "Rocky IV John G. Avildsen 7\n"                         +
            "Rocky V John G. Avildsen 8\n"                          +
            "Drainage Francisco Trindade N/A\n"                     +
            "The Shawshank Redemption Frank Darabont 10\n"          +
            "The Godfather Francis Ford Coppola 7\n"                +
            "Inception Frank Darabont 10\n"                         +
            "Pulp Fiction Quentin Tarantino 6\n"                    +
            "Iron Man Jon Favreau 8\n"                              +
            "Chicago Rob Marshall 7\n"                              +
            "Iron Man 2 Jon Favreau 7\n"                            +
            "The Iron Lady Phyllida Lloyd 6\n"                      +
            "Pretty Woman Garry Marshall 7\n" ;

        Assert.assertTrue(movieManager.viewAllMovies().contains(allMovies));
    }
}
