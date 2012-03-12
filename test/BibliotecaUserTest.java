import org.junit.Assert;
import org.junit.Test;
import twu.BibliotecaUser;
import twu.User;

public class BibliotecaUserTest extends BibliotecaTest{

    private BibliotecaUser bibliotecaUser = new BibliotecaUser();

    @Test
    public void test_should_be_able_login_with_correct_username_and_password(){
        User user = new User("111-1111", "pass1");

        Assert.assertTrue(bibliotecaUser.verifyUser(user));
    }

    @Test
    public void test_should_fail_to_login_when_provide_wrong_username_or_password(){
        User user_invalid_name = new User("111-0000", "pass1");
        User user_invalid_password = new User("111-1111", "pass2");
        User user_invalid = new User("111-0000", "0000");

        Assert.assertFalse(bibliotecaUser.verifyUser(user_invalid_name));
        Assert.assertFalse(bibliotecaUser.verifyUser(user_invalid_password));
        Assert.assertFalse(bibliotecaUser.verifyUser(user_invalid));
    }
}
