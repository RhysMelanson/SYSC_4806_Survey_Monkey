package JpaApplication.Model;

import javax.persistence.*;

@Entity
public class User{

    @Id
    private String userName;

    public User(){}

    public User(String userName)
    {
        this.userName = userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return this.userName;
    }

}
