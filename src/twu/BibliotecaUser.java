package twu;

import java.util.HashMap;
import java.util.Map;

public class BibliotecaUser{

    private static Map<String, String> usersList = new HashMap<String, String>();

    public BibliotecaUser(){
        loadUser();
    }

    public String verifyUser(User user){
        String currentUsername = user.getUsername();
        String currentPassword = user.getPassword();

        if(usersList.containsKey(currentUsername)){
            if(currentPassword.equals(usersList.get(currentUsername))) {
                user.setLoggedIn(true);
                return "User successfully login!";
            }
            else{
                user.setLoggedIn(false);
                return "Wrong password!";
            }
        }else{
            return "Username doesn't exist!";
        }
    }

    private void loadUser() {
        usersList.put("111-1111","pass1");
        usersList.put("111-1112","pass2");
        usersList.put("111-1113","pass3");
        usersList.put("111-1114","pass4");
        usersList.put("111-1115","pass5");
        usersList.put("111-1116","pass6");
    }
}
