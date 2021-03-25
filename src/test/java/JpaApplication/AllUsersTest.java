package JpaApplication;

import static org.junit.Assert.*;

import JpaApplication.Model.AllUsers;
import JpaApplication.Model.User;
import org.junit.Test;
import java.util.*;

public class AllUsersTest {
    @Test
    public void testId()
    {
        AllUsers users = new AllUsers();
        users.setId(52);
        assertEquals(52, users.getId());
    }
    @Test
    public void testGetUsers()
    {
        AllUsers users = new AllUsers();
        User testUser = new User("testName");
        users.addUser(testUser);
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(testUser);
        assertEquals(userList, users.getUsers());
    }
    @Test
    public void testAddUserTrue()
    {
        AllUsers users = new AllUsers();
        users.addUser(new User("testName"));
        assertEquals(1, users.getUsers().size());
    }
    @Test
    public void testAddUserFalse()
    {
        AllUsers users = new AllUsers();
        users.addUser(new User("testName"));
        users.addUser(new User("testName"));
        assertEquals(1, users.getUsers().size());
    }
    @Test
    public void testConstruction()
    {
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("testName"));
        AllUsers users = new AllUsers(userList);
        assertEquals(userList, users.getUsers());
    }
    @Test
    public void testRemoveUser()
    {
        AllUsers users = new AllUsers();
        users.addUser(new User("testName"));
        users.addUser(new User("testName2"));
        users.removeUser(1);
        assertEquals(1, users.getUsers().size());
    }
    @Test
    public void testFindUserTrue()
    {
        AllUsers users = new AllUsers();
        User testUser = new User("testName");
        users.addUser(testUser);
        assertEquals(testUser, users.findUser("testName"));
    }
    @Test
    public void testFindUserFalse()
    {
        AllUsers users = new AllUsers();
        assertEquals("", users.findUser("testName").getUserName());
    }
    @Test
    public void testLoginTrue()
    {
        AllUsers users = new AllUsers();
        users.addUser(new User("testName"));
        assertEquals(true, users.login("testName"));
    }
    @Test
    public void testLoginFalse()
    {
        AllUsers users = new AllUsers();
        assertEquals(false, users.login("testName"));
    }

}
