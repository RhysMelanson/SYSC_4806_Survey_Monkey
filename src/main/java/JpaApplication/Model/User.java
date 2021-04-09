package JpaApplication.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User{

    @Id
    private String userName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private Set<Survey> surveys;

    public User(){
        surveys = new HashSet<Survey>();
    }

    public User(String userName){
        this.userName = userName;
        surveys = new HashSet<Survey>();
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public void addSurvey(Survey survey) {
        surveys.add(survey);
    }

    public Set<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }
}
