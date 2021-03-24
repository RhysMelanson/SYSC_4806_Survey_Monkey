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
    public AllUsers(ArrayList<User> users){
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
        for(int i = 0;i<Users.size();i++)
        {
            if (user.getUserName() == Users.get(i).getUserName())
            {
                System.out.println("Username already in use");
                return;
            }
        }
        this.Users.add(user);
    }
    public void removeUser(int index)
    {
        this.Users.remove(index);
    }

    public User findUser(String userName)
    {
        for(int i = 0;i<Users.size();i++)
        {
            if (userName == Users.get(i).getUserName())
            {
                return Users.get(i);
            }
        }
        return new User("");
    }

    public boolean login(String userName)
    {
        for(int i = 0;i<Users.size();i++)
        {
            if (userName == Users.get(i).getUserName())
            {
                return true;
            }
        }
        return false;
    }
    public List<User> getUsers()
    {
        return this.Users;
    }
}
