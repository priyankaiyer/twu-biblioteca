package twu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<String> menu = new ArrayList<String> ();

    private BibliotecaMovie bibliotecaMovie = new BibliotecaMovie();
    private BibliotecaBook bibliotecaBook = new BibliotecaBook();

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
                System.out.println(reservation());
            }
            if(optionNumber == 3){
                System.out.println(checkLibraryNumber());
            }
            if(optionNumber == 4){
                System.out.println(bibliotecaMovie.viewAllMovies());
            }
        }catch (Exception e){
            System.out.println("Select a valid option!!");
        }
    }

    private String reservation() {
        System.out.println("Please input the number of the book to reserve!");

        String selection = getSelectionFromScreen();
        return bibliotecaBook.reserveBook(selection);
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
