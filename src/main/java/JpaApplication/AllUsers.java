package JpaApplication;

import javax.persistence.*;

import java.util.*;


@Entity
public class AllUsers {
    @Id
    @GeneratedValue
    private long Id;

    @OneToMany
    private List<User> Users;

    public AllUsers() {
        Users = new ArrayList<User>();
    }
    public AllUsers(List<User> users){
        this.Users = users;
    }

    public long getId()
    {
        return this.Id;
    }
    public void setId(long id)
    {
        this.Id = id;
    }

    public void addUser(User user)
    {
        if(Users.contains(new User(user.getUserName())))
        {
            System.out.println("Username already in use");
            return;
        }
        this.Users.add(user);
    }
    public void removeUser(int index)
    {
        this.Users.remove(index);
    }
    public User findUser(String userName)
    {
        if(Users.contains(new User(userName)))
        {
            return Users.get(Users.indexOf(new User(userName)));
        }
        return new User("");
    }

    public boolean login(String userName)
    {
        if(Users.contains(new User(userName)))
        {
            return true;
        }
        return false;
    }
}
