import org.junit.Assert;
import org.junit.Test;
import twu.Biblioteca;

public class BibliotecaTest {

    protected Biblioteca biblioteca = new Biblioteca();

    @Test
    public void test_should_show_welcome_message(){
        String welcomeMessage = "Welcome to Biblioteca Library!\n";
        Assert.assertTrue(biblioteca.showMenuOptions().contains(welcomeMessage));
    }

    @Test
    public void test_should_show_menu_options(){
        String menuOptions = "\n1. View all books." +
                "\n2. Reservation." +
                "\n3. Check library number." +
                "\n4. View all movies." +
                "\n5. Login." +
                "\n\nPlease enter the option you want!\n";
        Assert.assertTrue(biblioteca.showMenuOptions().contains(menuOptions));
    }

    @Test
    public void test_should_show_message_for_check_library_number_when_user_has_not_logged_in(){
        String notifiedMessage = "Please talk to Librarian. Thank you.";

        Assert.assertEquals(notifiedMessage, biblioteca.checkLibraryNumber());
    }
}
