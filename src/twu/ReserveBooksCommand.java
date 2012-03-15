package twu;

public class ReserveBooksCommand implements Command{
    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.bookReservation();
    }
}
