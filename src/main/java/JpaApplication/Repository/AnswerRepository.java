package JpaApplication.Repository;

import java.util.*;
import JpaApplication.Model.Answer;
import JpaApplication.Model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "answers", path = "answers")
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Answer findById(long id);
    Answer findByAnswer(String answer);
    List<Answer> findByAnswerAndQuestion(String answer, Question question);
}
