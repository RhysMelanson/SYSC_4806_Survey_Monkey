package JpaApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private long id;

    private String questions = "";
    private String answer = "";

    @ManyToOne
    private Survey survey;

    public Question(){}

    public Question(String questions) {
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "The answer to the Question: " + questions + " is: \n" + answer;
    }
}
