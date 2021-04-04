package JpaApplication.Model;
import javax.persistence.Entity;

@Entity
public class MultipleChoice extends QuestionType {

    private String answer1 = "";
    private String answer2 = "";
    private String answer3 = "";
    private String answer4 = "";

    public MultipleChoice() {
        super(TypeOfQuestion.MultipleChoice);
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    @Override
    public String toString() {
        return "Multiple-Choice Question";
    }

}
