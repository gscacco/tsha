package BusinessLogicTests.event.data;

import event.data.LoginData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mpanagrosso
 */
public class TestLoginData {

    static LoginData data;

    @BeforeClass
    public static void setUp() {
        data = new LoginData();

    }

    @Test
    public void shouldRetrieveUserLogin() {
        String user = "User1";
        String pwd = "PassWord1";
        data = new LoginData(user, pwd);
        Assert.assertEquals(data.getUserName(), user);
        Assert.assertEquals(data.getPassWord(), pwd);
    }

}
