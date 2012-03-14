package twu;

import java.util.Map;
import java.util.TreeMap;

public class BibliotecaBook {
    private Map<Integer, Book> bookList = new TreeMap<Integer, Book>();

    public BibliotecaBook(){
        loadBookCollection();
    }

    public void loadBookCollection() {
        bookList.put(1, new Book("01", "name1", "author1", false));
        bookList.put(2, new Book("02", "name2", "author2", false));
        bookList.put(3, new Book("03", "name3", "author3", true));
        bookList.put(4, new Book("04", "name4", "author4", false));
        bookList.put(5, new Book("05", "name5", "author5", true));
    }

    public String viewAllBooks() {
        String booksDisplay = "";
        for (Map.Entry<Integer,Book> entry : bookList.entrySet()) {
            booksDisplay += entry.getValue().toString()+ "\n";
        }
        return booksDisplay;
    }

    public String reserveBook(String bookNumber) {
        Integer bookNumberInteger = new Integer(bookNumber);
        boolean reserved;
        if(!bookList.containsKey(bookNumberInteger))
            reserved = true;
        if( bookList.get(bookNumberInteger).isReserved()){
            reserved = true;
        }else{
            bookList.get(bookNumberInteger).setReserved(true);
            reserved = false;
        }
        return getBookReservationStatus(reserved);
    }

    private String getBookReservationStatus(boolean status) {
        if(status)
            return "Sorry we don't have that book yet.";
        else
            return "Thank You! Enjoy the book.";
    }
}
