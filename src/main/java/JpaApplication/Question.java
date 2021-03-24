package JpaApplication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private long id;

    private String questions = "";

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answers;

    @ManyToOne
    private Survey survey;

    public Question(){}

    public Question(String question) {
        this.questions = question;
    }

    public Question(String question, List<Answer> answers) {
        this.questions = question;
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    public void setAnswersByType(String type) {
        if(type.equals("Open-Ended")) {
            answers = new ArrayList<Answer>();
        }else {
            answers = new ArrayList<Answer>();
        }
    }

    public Answer getAnswer(int index) {
        return answers.get(index);
    }

    public void removeAnswer(int index) {
        answers.remove(index);
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

    public void setQuestions(String question) {
        this.questions = question;
    }

    @Override
    public String toString() {
        return "The answer to the Question: " + questions + " is:" + answers;
    }
}
