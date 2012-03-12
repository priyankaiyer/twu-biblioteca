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
                "\n\nPlease enter the option you want!\n";
        Assert.assertTrue(biblioteca.showMenuOptions().contains(menuOptions));
    }

    @Test
    public void test_should_notify_when_selected_invalid_option(){
        String notifiedMessage = "Select a valid option!!";
        int invalidNumber = 10;

        Assert.assertEquals(notifiedMessage, biblioteca.checkMenuSelection(invalidNumber));
    }

    @Test
    public void test_should_show_proper_message_when_select_valid_option(){
        String notifiedMessage = "Selected 1: View all books.\n";
        int validNumber = 1;
        Assert.assertEquals(notifiedMessage, biblioteca.checkMenuSelection(validNumber));
    }

    @Test
    public void test_user_can_check_their_library_number(){
        String notifiedMessage = "Please talk to Librarian. Thank you.";

        Assert.assertEquals(notifiedMessage, biblioteca.checkLibraryNumber());
    }
}
