package twu;

public enum CommandOption {
    ViewAllBooks(1, new ViewAllBooksCommand()),
    ReserveBooks(2, new ReserveBooksCommand()),
    CheckLibraryNumber(3, new CheckLibraryNumberCommand()),
    ViewAllMovies(4, new ViewAllMoviesCommand()),
    UserLogin(5, new UserLoginCommand());
    
    private  int selectionKey;
    private Command command;
    
    private CommandOption(int selectionKey, Command command){
        this.selectionKey = selectionKey;
        this.command = command;
    }

    public static CommandOption getFromKey(int key){
        for(CommandOption optionsItem : values()) {
            if (optionsItem.selectionKey == key) {
                return optionsItem;
            }
        }
        throw new IllegalArgumentException("invalid key");
    }

    public Command getCommand() {
        return command;
    }
}

class ViewAllBooksCommand implements Command{

    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.getBibliotecaBook().viewAllBooks();
    }
}

class ReserveBooksCommand implements Command{
    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.bookReservation();
    }
}

class CheckLibraryNumberCommand implements Command{
    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.checkLibraryNumber();
    }
}

class ViewAllMoviesCommand implements Command{

    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.getBibliotecaMovie().viewAllMovies();
    }
}

class UserLoginCommand implements Command {
    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.userLogin();
    }
}
