package twu;

import java.util.ArrayList;

public class Biblioteca {

    ScreenReader screenReader = new ScreenReader();

    private ArrayList<String> menu = new ArrayList<String> ();

    private MovieManager movieManager = new MovieManager();
    private BookManager bookManager = new BookManager();
    private UserManager userManager = new UserManager();

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

    public void performSelection(){
        String selection = screenReader.getSelectionFromScreen();
        try{
            int optionNumber = Integer.parseInt(selection);

            if(optionNumber == 0 || optionNumber > menu.size())
                System.out.println("Select a valid option!!");

            CommandOption commandOption = CommandOption.getFromKey(optionNumber);
            System.out.println(commandOption.getCommand().execute(this));

        }catch (Exception e){
            System.out.println("Select a valid option!!");
        }
    }

    protected String userLogin() {
        if(currentUser.isLoggedIn())
            return "You've logged in.";

        System.out.println("Please enter your username/library number.");
        String currentUsername = screenReader.getSelectionFromScreen();

        System.out.println("Please enter your password.");
        String currentPassword = screenReader.getSelectionFromScreen();

        currentUser = new User(currentUsername, currentPassword);
        return userManager.verifyUser(currentUser);
    }

    protected String bookReservation() {
        if(currentUser.isLoggedIn()){
            System.out.println("Please input the number of the book to reserve!");

            String selection = screenReader.getSelectionFromScreen();
            return bookManager.reserveBook(selection);
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

    public BookManager getBookManager() {
        return bookManager;
    }

    public MovieManager getMovieManager() {
        return movieManager;
    }
}