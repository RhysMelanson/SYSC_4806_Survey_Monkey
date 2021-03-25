package JpaApplication.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Answer {

    @Id
    @GeneratedValue
    private long id;

    protected String answer = "";

    @ManyToOne
    protected Question question;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
//
//    public String getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }
}
