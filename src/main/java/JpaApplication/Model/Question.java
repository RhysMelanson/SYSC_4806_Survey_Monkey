package JpaApplication.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private long id;

    private String questions = "";
    private String questionType = "";

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answers;

    @ManyToOne
    private Survey survey;

    public Question(){
        answers = new ArrayList<Answer>();
    }

    public Question(String question) {
        this.questions = question;
        answers = new ArrayList<Answer>();
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

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        String s =  questions + " : \n";
        int i = 0;
        for(Answer answer : answers) {
            i++;
            s += i + " | " + answer + '\n';
        }
        return s;
    }
}
