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
    private List<QuestionInfo> questionInfos;

    public Survey() {
        questionInfos = new ArrayList<QuestionInfo>();
    }

    public Survey(List<QuestionInfo> questionInfos) {
        this.questionInfos = questionInfos;
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

    public void addQuestionInfo(QuestionInfo questionInfo) {
        questionInfos.add(questionInfo);
    }

    public List<QuestionInfo> getQuestionInfos() {
        return questionInfos;
    }

    public void setQuestionInfos(List<QuestionInfo> survey) {
        this.questionInfos = survey;
    }

    public QuestionInfo getQuestionInfo(int index) {
        return questionInfos.get(index);
    }

    public void removeQuestionInfo(int index) {
        questionInfos.remove(index);
    }

    @Override
    public String toString() {
        String s =  name + " : \n";
        int i = 0;
        for(QuestionInfo questionInfo: questionInfos) {
            i++;
            s += i + " | " + questionInfo + '\n';
        }
        return s;
    }
}
