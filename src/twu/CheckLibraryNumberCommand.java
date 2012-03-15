package twu;

public class CheckLibraryNumberCommand implements Command{
    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.checkLibraryNumber();
    }
}

