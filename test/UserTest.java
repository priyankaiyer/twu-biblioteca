import org.junit.Assert;
import org.junit.Test;
import twu.User;

public class UserTest {
    @Test
    public void checkUserToString(){
        User usr = new User("111-1111", "password1");
        String usrString = "111-1111 password1";
        Assert.assertEquals(usrString, usr.toString());
    }

}
