package twu;

public class ViewAllMoviesCommand implements Command{

    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.getBibliotecaMovie().viewAllMovies();
    }
}
