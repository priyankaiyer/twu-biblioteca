package twu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Biblioteca {

    private ArrayList<String> menu = new ArrayList<String> ();
    private Map<Integer, Book> bookList = new TreeMap<Integer, Book>();

    public Biblioteca(){
        loadBookCollection();
        loadMenu();
    }

    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();

        while(true){
            System.out.println(biblioteca.showMenuOptions());
            biblioteca.performSelection();
        }
    }

    private void loadMenu() {
        menu.add("View all books.");
        menu.add("Reservation.");
        menu.add("Check library number.");
        menu.add("View all movies.");
    }

    public String showMenuOptions() {
        String welcomeMessage =
                "------------------------------\nWelcome to Biblioteca Library!\n------------------------------\n";
        String menu_options = welcomeMessage;
        for(String entry : menu){
            menu_options += "\n"+ (menu.indexOf(entry)+1) +". "+ entry;
        }
        menu_options += "\n\nPlease enter the option you want!\n";
        return menu_options;
    }

    public String checkMenuSelection(int number) {
        String choice = "";
        try{
            if(menu.get(number-1)!=null)
              choice = "Selected " + (number) + ": " + menu.get(number-1) + "\n";
        }catch(Exception e ){
            choice = "Select a valid option!!";
        }
        return choice;
    }

    public void performSelection(){
        String selection = getSelectionFromScreen();
        try{
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
        }catch (Exception e){
            System.out.println("Select a valid option!!");
        }
    }

    public String viewAllBooks() {
        String booksDisplay = "";
        for (Map.Entry<Integer,Book> entry : bookList.entrySet()) {
            booksDisplay += entry.getValue().toString()+ "\n";
        }
        return booksDisplay;
    }

    public void loadBookCollection() {
        bookList.put(1, new Book("01", "name1", "author1", false));
        bookList.put(2, new Book("02", "name2", "author2", false));
        bookList.put(3, new Book("03", "name3", "author3", true));
        bookList.put(4, new Book("04", "name4", "author4", false));
        bookList.put(5, new Book("05", "name5", "author5", true));
    }

    private String reservation() {
        System.out.println("Please input the number of the book to reserve!");

        String selection = getSelectionFromScreen();
        return reserveBook(selection);
    }

    public String reserveBook(String bookNumber) {
        Integer bookNumberInteger = new Integer(bookNumber);
        boolean reserved;
        if(bookList.containsKey(bookNumberInteger)){
            if( bookList.get(bookNumberInteger).isReserved())
                reserved = true;
            else{
                bookList.get(bookNumberInteger).setReserved(true);
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
        return "Please talk to Librarian. Thank you.";
    }

    private String getSelectionFromScreen(){
        BufferedReader reader = newReaderFromScreen();
        try{
            return reader.readLine();
        }catch (Exception e){
            return "0";
        }
    }
    
    private BufferedReader newReaderFromScreen() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
