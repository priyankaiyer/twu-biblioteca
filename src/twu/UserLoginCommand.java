package twu;

public class UserLoginCommand implements Command {

    @Override
    public String execute(Biblioteca biblioteca){
        return biblioteca.userLogin();
    }
}
