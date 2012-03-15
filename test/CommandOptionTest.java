import org.junit.Assert;
import org.junit.Test;
import twu.Biblioteca;
import twu.CommandOption;

public class CommandOptionTest {

    protected Biblioteca biblioteca = new Biblioteca();

    @Test
    public void test_should_execute_view_all_book(){
        int optionNumber = 1;
        CommandOption commandOption = CommandOption.getFromKey(optionNumber);

        String allBooks=
                "01 name1 author1 available\n" +
                        "02 name2 author2 available\n" +
                        "03 name3 author3 reserved\n" +
                        "04 name4 author4 available\n" +
                        "05 name5 author5 reserved\n" ;
        Assert.assertEquals(allBooks, commandOption.getCommand().execute(biblioteca));
    }

    @Test
    public void test_should_execute_check_library_number(){
        int optionNumber = 3;
        CommandOption commandOption = CommandOption.getFromKey(optionNumber);
        String notifiedMessage = "Please talk to Librarian. Thank you.";
        
        Assert.assertEquals(notifiedMessage, commandOption.getCommand().execute(biblioteca));
    }

    @Test
    public void test_should_execute_view_all_movies(){
        int optionNumber = 4;
        CommandOption commandOption = CommandOption.getFromKey(optionNumber);
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

        Assert.assertEquals(allMovies, commandOption.getCommand().execute(biblioteca));
    }
}
