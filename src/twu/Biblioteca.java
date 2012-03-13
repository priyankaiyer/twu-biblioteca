package twu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<String> menu = new ArrayList<String> ();

    private BibliotecaMovie bibliotecaMovie = new BibliotecaMovie();
    private BibliotecaBook bibliotecaBook = new BibliotecaBook();
    private BibliotecaUser bibliotecaUser = new BibliotecaUser();

    private User currentUser = new User("000", "000");

    public Biblioteca(){
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
        menu.add("Login.");
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
                System.out.println(bibliotecaBook.viewAllBooks());
            }
            if(optionNumber == 2){
                System.out.println(bookReservation());
            }
            if(optionNumber == 3){
                System.out.println(checkLibraryNumber());
            }
            if(optionNumber == 4){
                System.out.println(bibliotecaMovie.viewAllMovies());
            }
            if(optionNumber == 5){
                System.out.println(userLogin());
            }
        }catch (Exception e){
            System.out.println("Select a valid option!!");
        }
    }

    private String userLogin() {
        if(currentUser.isLoggedIn())
            return "You've logged in.";

        System.out.println("Please enter your username/library number.");
        String currentUsername = getSelectionFromScreen();

        System.out.println("Please enter your password.");
        String currentPassword = getSelectionFromScreen();

        currentUser = new User(currentUsername, currentPassword);
        return bibliotecaUser.verifyUser(currentUser);
    }

    private String bookReservation() {
        if(currentUser.isLoggedIn()){
            System.out.println("Please input the number of the book to reserve!");

            String selection = getSelectionFromScreen();
            return bibliotecaBook.reserveBook(selection);
        }
        else
            return "Please Login first.";
    }

    public String checkLibraryNumber() {
        if(currentUser.isLoggedIn())
            return currentUser.getUsername();
        else
            return "Please talk to Librarian. Thank you.";
    }

    protected String getSelectionFromScreen(){
        BufferedReader reader = newReaderFromScreen();
        try{
            String inputLine = reader.readLine();
            while(inputLine.trim().equals("")){
                System.out.println("Input cannot be blank. Please re-enter.");
                inputLine = reader.readLine();
            }
            return inputLine;
        }catch (Exception e){
            return "0";
        }
    }
    
    protected BufferedReader newReaderFromScreen() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
