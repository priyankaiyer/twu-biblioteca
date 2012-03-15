package twu;

public class ViewAllBooksCommand implements Command{

    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.getBibliotecaBook().viewAllBooks();
    }
}
