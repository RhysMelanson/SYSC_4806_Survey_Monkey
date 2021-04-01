package JpaApplication.Model;
import javax.persistence.*;

@Entity
public abstract class QuestionType {

    @Id
    @GeneratedValue
    protected long id;

    @OneToOne
    protected Question question;

    protected TypeOfQuestion type = TypeOfQuestion.OpenEnded;

    public enum TypeOfQuestion {
        /**
         * Represents an Open-Ended question
         */
        OpenEnded,
        /**
         * Represents a Multiple-choice question
         */
        MultipleChoice,
        /**
         * Represents a range of numbers question
         */
        NumberRange
    }

    public QuestionType(){}

    public QuestionType(TypeOfQuestion type){
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeOfQuestion getType() {
        return type;
    }

    public void setType(TypeOfQuestion type) {
        this.type = type;
    }

    @Override
    public abstract String toString();
}
