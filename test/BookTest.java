import org.junit.Assert;
import org.junit.Test;
import twu.Book;

public class BookTest {

    @Test
    public void checkAvailableBookToString(){
        Book book1 = new Book("01", "name1", "author1", false);
        String bookString = "01 name1 author1 available";
        Assert.assertEquals(bookString, book1.toString());
    }

    @Test
    public void checkReservedBookToString(){
        Book book2 = new Book("02", "name2", "author2", true);
        String bookString = "02 name2 author2 reserved";
        Assert.assertEquals(bookString, book2.toString());
    }

}
