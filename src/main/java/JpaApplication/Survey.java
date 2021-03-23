package JpaApplication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Survey {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "survey")
    private List<Question> questions;

    public Survey() {
        questions = new ArrayList<Question>();
    }

    public Survey(List<Question> questions) {
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addQuestionInfo(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestionInfos() {
        return questions;
    }

    public void setQuestionInfos(List<Question> survey) {
        this.questions = survey;
    }

    public Question getQuestionInfo(int index) {
        return questions.get(index);
    }

    public void removeQuestionInfo(int index) {
        questions.remove(index);
    }

    @Override
    public String toString() {
        String s =  name + " : \n";
        int i = 0;
        for(Question question : questions) {
            i++;
            s += i + " | " + question + '\n';
        }
        return s;
    }
}
