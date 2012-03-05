package twu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Biblioteca {

    private String welcomeMessage = "Welcome to Biblioteca!";
    private Map<Integer, String> menu = new HashMap<Integer, String>();
    private Map<String, Book> bookList = new TreeMap<String, Book>();

    public Biblioteca(){
        menu.put(1, "View all books");
        menu.put(2, "Reservation");
        menu.put(3, "Check library number");

        loadBookCollection();
    }

    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.getWelcomeMessage());

        while(true){
            System.out.println(biblioteca.showMenuOptions());
            biblioteca.performSelection();
        }
    }

    public  String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String showMenuOptions() {
        String menuOptions = "-------\n1. View all books." +
                "\n2. Reservation." +
                "\n3. Check library number." +
                "\n\nPlease enter the option you want!\n";
        return menuOptions;
    }

    public String checkMenuSelection(int number) {
        String notifiedMessage = "Select a valid option!!";
        if(menu.containsKey(number)){
            return notifiedMessage = "Selected " + number + ": " + menu.get(number) + "\n";
        }else
            return notifiedMessage;
    }

    public void performSelection(){
        String selection = getSelectionFromScreen();
        int optionNumber = Integer.parseInt(selection);
        System.out.println(checkMenuSelection(optionNumber));

        if(optionNumber == 1){
            System.out.println(viewAllBooks());
        }
        if(optionNumber == 2){
            System.out.println(reservation());
        }
        if(optionNumber == 3){
            System.out.println(checkLibraryNumber());
        }
    }

    public String viewAllBooks() {
        String booksDisplay = "";
        Iterator iterator = bookList.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            booksDisplay += entry.getValue().toString()+ "\n";
        }
        return booksDisplay;
    }

    public void loadBookCollection() {
        bookList.put("1", new Book("01", "name1", "author1", false));
        bookList.put("2", new Book("02", "name2", "author2", false));
        bookList.put("3", new Book("03", "name3", "author3", true));
        bookList.put("4", new Book("04", "name4", "author4", false));
        bookList.put("5", new Book("05", "name5", "author5", true));
    }

    private String reservation() {
        System.out.println("Please input the number of the book to reserve!");

        String selection = getSelectionFromScreen();
        return reserveBook(selection);
    }

    public String reserveBook(String bookNumber) {
        boolean reserved = false;
        if(bookList.containsKey(bookNumber)){
            if( bookList.get(bookNumber).isReserved())
                reserved = true;
            else{
                bookList.get(bookNumber).setReserved(true);
                reserved = false;
            }
        }else
            reserved = true;
        return getBookReservationStatus(reserved);
    }

    private String getBookReservationStatus(boolean status) {
        if(status)
            return "Sorry we don't have that book yet.";
        else
            return "Thank You! Enjoy the book.";
    }

    public String checkLibraryNumber() {
        String notifiedMessage = "Please talk to Librarian. Thank you.";

        return notifiedMessage;
    }

    private String getSelectionFromScreen(){
        BufferedReader reader = newReaderFromScreen();
        try{
            return reader.readLine();
        }catch (Exception e){
            return "0";
        }
    }
    
    private static BufferedReader newReaderFromScreen() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
