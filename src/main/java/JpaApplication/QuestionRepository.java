package JpaApplication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
public interface QuestionRepository extends CrudRepository<Question, Long> {

    Question findById(long id);
    Question findByQuestion(String question);
}