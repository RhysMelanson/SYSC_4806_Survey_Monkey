package JpaApplication.Model;

import javax.persistence.*;

@Entity
public class User{

    @Id
    @GeneratedValue
    private long Id;

    private String userName;

    public User(String userName)
    {
        this.userName = userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }


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

}
