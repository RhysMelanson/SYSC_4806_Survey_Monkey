package JpaApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private long id;

    private String questions = "";
    private String radioButtonSelectedValue = "";
    private int answersCount = 0;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
    private QuestionType questionType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
    @JsonManagedReference
    private Set<Answer> answers;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference
    private Survey survey;

    public Question(){
        answers = new HashSet<Answer>();
    }

    public Question(String question) {
        this.questions = question;
        answers = new HashSet<Answer>();
    }

    public Question(String question, Set<Answer> answers) {
        this.questions = question;
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
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

    public String getRadioButtonSelectedValue() {
        return radioButtonSelectedValue;
    }

    public void setRadioButtonSelectedValue(String radioButtonSelectedValue) {
        this.radioButtonSelectedValue = radioButtonSelectedValue;
    }

    public int getAnswersCount() {
        return answers.size();
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
        survey.addQuestions(this);
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
