package JpaApplication.Model;
import javax.persistence.Entity;

@Entity
public class OpenEnded extends QuestionType {

    public OpenEnded() {
        super(TypeOfQuestion.OpenEnded);
    }

    @Override
    public String toString() {
        return "Open-Ended Question";
    }

}
