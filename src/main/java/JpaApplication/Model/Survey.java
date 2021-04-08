package JpaApplication.Model;

import JpaApplication.Model.Question;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Survey {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "survey")
    @JsonManagedReference
    private Set<Question> questions;

    public Survey() {
        questions = new HashSet<Question>();
    }

    public Survey(Set<Question> questions) {
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

    public void addQuestions(Question question) {
        questions.add(question);
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> survey) {
        this.questions = survey;
    }

    public void removeQuestionInfo(Question question) {
        questions.remove(question);
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
