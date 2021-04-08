package JpaApplication.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private long id;

    private String answer = "";

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference
    private Question question;

    public Answer(){
    }

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
        question.addAnswer(this);
    }

    @Override
    public String toString() {
        return answer;
    }
}
