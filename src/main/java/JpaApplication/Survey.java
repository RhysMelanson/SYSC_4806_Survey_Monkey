package JpaApplication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Survey {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<QuestionInfo> survey;

    public Survey() {
        survey = new ArrayList<QuestionInfo>();
    }

    public Survey(List<QuestionInfo> survey) {
        this.survey = survey;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addQuestionInfo(QuestionInfo questionInfo) {
        survey.add(questionInfo);
    }

    public List<QuestionInfo> getSurvey() {
        return survey;
    }

    public void setSurvey(List<QuestionInfo> survey) {
        this.survey = survey;
    }

    public QuestionInfo getQuestionInfo(int index) {
        return survey.get(index);
    }

    public void removeQuestionInfo(int index) {
        survey.remove(index);
    }

    @Override
    public String toString() {
        String s =  "Survey: \n";
        int i = 0;
        for(QuestionInfo questionInfo: survey) {
            i++;
            s += i + " | " + questionInfo + '\n';
        }
        return s;
    }
}
