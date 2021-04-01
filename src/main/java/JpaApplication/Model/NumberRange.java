package JpaApplication.Model;
import javax.persistence.Entity;

@Entity
public class NumberRange extends QuestionType {

    private int min = 0;
    private int max = 10;

    public NumberRange() {
        super(TypeOfQuestion.NumberRange);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Number-range Question";
    }

}
