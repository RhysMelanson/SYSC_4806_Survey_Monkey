package JpaApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class QuestionInfo {

    @Id
    @GeneratedValue
    private long id;

    private String question = "";
    private String answer = "";

    @ManyToOne
    private Survey survey;

    public QuestionInfo(){}

    public QuestionInfo(String question) {
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        String s = "Then answer to the Question: " + question + "is: \n" + answer;
        return s;
    }
}
