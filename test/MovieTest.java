import org.junit.Assert;
import org.junit.Test;
import twu.Movie;

public class MovieTest {

    @Test
    public void checkRatedMovieEntryToString(){
        Movie movie1 = new Movie("name1", "director1", "8");
        String MovieString = "name1 director1 8";
        Assert.assertEquals(MovieString, movie1.toString());
    }

    @Test
    public void checkNoRateMovieEntryToString(){
        Movie movie2 = new Movie("name2", "director2", "N/A");
        String MovieString = "name2 director2 N/A";
        Assert.assertEquals(MovieString, movie2.toString());
    }
}
