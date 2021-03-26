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

    private int questionType = -1;
    private String multipleChoiceAnswer1 = "";
    private String multipleChoiceAnswer2 = "";
    private String multipleChoiceAnswer3 = "";
    private String multipleChoiceAnswer4 = "";
    private int numberMinOption = 0;
    private int numberMaxOption = 10;

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

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
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

    public String getMultipleChoiceAnswer1() {
        return multipleChoiceAnswer1;
    }

    public void setMultipleChoiceAnswer1(String multipleChoiceAnswer1) {
        this.multipleChoiceAnswer1 = multipleChoiceAnswer1;
    }

    public String getMultipleChoiceAnswer2() {
        return multipleChoiceAnswer2;
    }

    public void setMultipleChoiceAnswer2(String multipleChoiceAnswer2) {
        this.multipleChoiceAnswer2 = multipleChoiceAnswer2;
    }

    public String getMultipleChoiceAnswer3() {
        return multipleChoiceAnswer3;
    }

    public void setMultipleChoiceAnswer3(String multipleChoiceAnswer3) {
        this.multipleChoiceAnswer3 = multipleChoiceAnswer3;
    }

    public String getMultipleChoiceAnswer4() {
        return multipleChoiceAnswer4;
    }

    public void setMultipleChoiceAnswer4(String multipleChoiceAnswer4) {
        this.multipleChoiceAnswer4 = multipleChoiceAnswer4;
    }

    public int getNumberMinOption() {
        return numberMinOption;
    }

    public void setNumberMinOption(int numberMinOption) {
        this.numberMinOption = numberMinOption;
    }

    public int getNumberMaxOption() {
        return numberMaxOption;
    }

    public void setNumberMaxOption(int numberMaxOption) {
        this.numberMaxOption = numberMaxOption;
    }

    public String typeToString() {
        String s = "Not picked yet";
        switch(this.questionType) {
            case 0:
                s = "Open-Ended Question";
            case 1:
                s = "Multiple-Choice Question";
            case 2:
                s = "Number-Range Question";
        }
        return s;
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
