import org.junit.Assert;
import org.junit.Test;
import twu.Biblioteca;

public class BibliotecaTest {

    private Biblioteca biblioteca = new Biblioteca();

    @Test
    public void testShouldShowWelcomeMessage(){
        String welcomeMessage = "Welcome to Biblioteca!";
        Assert.assertEquals(welcomeMessage, biblioteca.getWelcomeMessage());
    }

    @Test
    public void testShouldShowMenuOptions(){
        String menuOptions = "-------\n1. View all books." +
                "\n2. Reservation." +
                "\n3. Check library number." +
                "\n\nPlease enter the option you want!\n";
        Assert.assertEquals(menuOptions, biblioteca.showMenuOptions());
    }

    @Test
    public void testShouldNotifyWhenSelectedInvalidOption(){
        String notifiedMessage = "Select a valid option!!";
        int invalidNumber = 10;
        Assert.assertEquals(notifiedMessage, biblioteca.checkMenuSelection(invalidNumber));
    }

    @Test
    public void testShouldShowProperMessageWhenSelectValidOption(){
        String notifiedMessage = "Selected 1: View all books\n";
        int validNumber = 1;
        Assert.assertEquals(notifiedMessage, biblioteca.checkMenuSelection(validNumber));
    }

    @Test
    public void testShouldBeAbleViewAllBooksInLibrary(){
        String allBooks=
                "01 name1 author1 available\n" +
                "02 name2 author2 available\n" +
                "03 name3 author3 reserved\n" +
                "04 name4 author4 available\n" +
                "05 name5 author5 reserved\n" ;
        Assert.assertEquals(allBooks, biblioteca.viewAllBooks());
    }

    @Test
    public void testUserCanReserveBookWhenAvailable(){
        String bookNumber = "01";
        String notifiedMessage = "Thank You! Enjoy the book.";

        Assert.assertEquals(notifiedMessage, biblioteca.reserveBook(bookNumber));
    }

    @Test
    public void testUserCannotReserveBookWhenItHasBeenReserved(){
        String bookNumber = "01";
        String notifiedMessage = "Sorry we don't have that book yet.";
        
        biblioteca.reserveBook(bookNumber);
        Assert.assertEquals(notifiedMessage, biblioteca.reserveBook(bookNumber));
    }

    @Test
    public void testUserCanCheckTheirLibraryNumber(){
        String notifiedMessage = "Please talk to Librarian. Thank you.";

        Assert.assertEquals(notifiedMessage, biblioteca.checkLibraryNumber());
    }
}
