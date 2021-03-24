package JpaApplication;

import javax.persistence.*;
import java.util.*;

@Entity
public class User{

    @Id
    @GeneratedValue
    private long Id;

    private String userName;
    //private String userPass;

    @ManyToOne
    private AllUsers allUsers;

    public User(String userName)
    {
        this.userName = userName;
    }
    /*public User(String userName, String userPass)
    {
        this.userName = userName;
        this.userPass = userPass;
    }*/

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

   /* public void setPassword(String userPass)
    {
        this.userPass = userPass;
    }*/

    public void setId(long Id)
    {
        this.Id = Id;
    }

    public long getId()
    {
        return this.Id;
    }
    public String getUserName()
    {
        return this.userName;
    }
    /*public String getPassword()
    {
        return this.userPass;
    }*/
}
