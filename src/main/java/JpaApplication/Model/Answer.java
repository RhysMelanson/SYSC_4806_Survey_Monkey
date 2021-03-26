package JpaApplication.Model;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private long id;

    private String answer = "";

    @ManyToOne
    private Question question;

    public Answer(){}

    public Answer(String answer){
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return answer;
    }
}
