package JpaApplication.Model.Answers;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.List;

@Entity
public class MultipleChoice extends Answer {

    private String answer1 = "";
    private String answer2 = "";
    private String answer3 = "";
    private String answer4 = "";

    public MultipleChoice(){}

    public MultipleChoice(String answer1, String answer2, String answer3, String answer4){
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }


    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer) {
        this.answer1 = answer;
    }
    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer) {
        this.answer2 = answer;
    }
    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer) {
        this.answer3 = answer;
    }
    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "A) " + answer1 + ", B) " + answer2 +
                ", C) " + answer3 + ", D) " + answer4;

    }
}
