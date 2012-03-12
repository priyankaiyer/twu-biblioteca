import org.junit.Assert;
import org.junit.Test;

public class BibliotecaMovieTest extends BibliotecaTest{

    @Test
    public void test_should_show_view_movie_menu_item(){
        String viewMovieMenuItem = "View all movies.";
        Assert.assertTrue(biblioteca.showMenuOptions().contains(viewMovieMenuItem));
    }



}
