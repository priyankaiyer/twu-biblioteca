import org.junit.Assert;
import org.junit.Test;
import twu.UserManager;
import twu.User;

public class UserManagerTest extends BibliotecaTest{

    private UserManager userManager = new UserManager();
    
    @Test
    public void test_should_login_menu_item(){
        String loginMenuItem = "Login.";

        Assert.assertTrue(biblioteca.showMenuOptions().contains(loginMenuItem));
    }

    @Test
    public void test_should_be_able_login_with_correct_username_and_password(){
        User user = new User("111-1111", "pass1");

        Assert.assertEquals("User successfully login!", userManager.verifyUser(user));
    }

    @Test
    public void test_should_fail_to_login_when_provide_wrong_username_or_password(){
        User user_invalid_name = new User("111-0000", "pass1");
        User user_invalid_password = new User("111-1111", "pass2");
        User user_invalid = new User("111-0000", "0000");

        Assert.assertEquals("Username doesn't exist!", userManager.verifyUser(user_invalid_name));
        Assert.assertEquals(false, user_invalid_name.isLoggedIn());

        Assert.assertEquals("Wrong password!", userManager.verifyUser(user_invalid_password));
        Assert.assertEquals(false, user_invalid_password.isLoggedIn());

        Assert.assertEquals("Username doesn't exist!", userManager.verifyUser(user_invalid));
        Assert.assertEquals(false, user_invalid.isLoggedIn());
    }
}
