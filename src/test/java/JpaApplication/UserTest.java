package JpaApplication;

import static org.junit.Assert.*;

import JpaApplication.Model.User;
import org.junit.Test;

public class UserTest {
    @Test
    public void testGetUserName(){
        User user = new User("testName");
        assertEquals("testName", user.getUserName());
    }
    @Test
    public void testSetUserName(){
        User user = new User("test1");
        user.setUserName("test2");
        assertEquals("test2", user.getUserName());
    }
}
