import org.junit.Assert;
import org.junit.Test;
import twu.Biblioteca;

public class BibliotecaTest {

    private Biblioteca biblioteca = new Biblioteca();

    @Test
    public void test_should_show_welcome_message(){
        String welcomeMessage = "Welcome to Biblioteca!\n";
        Assert.assertTrue(biblioteca.showMenuOptions().contains(welcomeMessage));
    }

    @Test
    public void test_should_show_menu_options(){
        String menuOptions = "-------\n1. View all books." +
                "\n2. Reservation." +
                "\n3. Check library number." +
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
        String notifiedMessage = "Selected 1: View all books\n";
        int validNumber = 1;
        Assert.assertEquals(notifiedMessage, biblioteca.checkMenuSelection(validNumber));
    }

    @Test
    public void test_should_be_able_view_all_books_in_library(){
        String allBooks=
                "01 name1 author1 available\n" +
                "02 name2 author2 available\n" +
                "03 name3 author3 reserved\n" +
                "04 name4 author4 available\n" +
                "05 name5 author5 reserved\n" ;
        Assert.assertEquals(allBooks, biblioteca.viewAllBooks());
    }

    @Test
    public void test_user_can_reserve_book_when_available(){
        String bookNumber = "1";
        String notifiedMessage = "Thank You! Enjoy the book.";

        Assert.assertEquals(notifiedMessage, biblioteca.reserveBook(bookNumber));
    }

    @Test
    public void test_user_can_not_reserve_book_when_it_has_been_reserved(){
        String bookNumber = "01";
        String notifiedMessage = "Sorry we don't have that book yet.";
        
        biblioteca.reserveBook(bookNumber);
        Assert.assertEquals(notifiedMessage, biblioteca.reserveBook(bookNumber));
    }

    @Test
    public void test_user_can_check_their_library_number(){
        String notifiedMessage = "Please talk to Librarian. Thank you.";

        Assert.assertEquals(notifiedMessage, biblioteca.checkLibraryNumber());
    }
}
