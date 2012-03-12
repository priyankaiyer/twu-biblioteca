import org.junit.Assert;
import org.junit.Test;
import twu.BibliotecaBook;

public class BibliotecaBookTest extends BibliotecaTest {

    protected BibliotecaBook bibliotecaBook = new BibliotecaBook();

    @Test
    public void test_should_be_able_view_all_books_in_library(){
        String allBooks=
                "01 name1 author1 available\n" +
                        "02 name2 author2 available\n" +
                        "03 name3 author3 reserved\n" +
                        "04 name4 author4 available\n" +
                        "05 name5 author5 reserved\n" ;
        Assert.assertEquals(allBooks, bibliotecaBook.viewAllBooks());
    }

    @Test
    public void test_user_can_reserve_book_when_available(){
        String bookNumber = "01";
        String notifiedMessage = "Thank You! Enjoy the book.";

        Assert.assertEquals(notifiedMessage, bibliotecaBook.reserveBook(bookNumber));
    }

    @Test
    public void test_user_can_not_reserve_book_when_it_has_been_reserved(){
        String bookNumber = "02";
        String SuccessNotifiedMessage = "Thank You! Enjoy the book.";
        String failNotifiedMessage = "Sorry we don't have that book yet.";

        Assert.assertEquals(SuccessNotifiedMessage, bibliotecaBook.reserveBook(bookNumber));
        bibliotecaBook.reserveBook(bookNumber);
        Assert.assertEquals(failNotifiedMessage, bibliotecaBook.reserveBook(bookNumber));
    }

}
