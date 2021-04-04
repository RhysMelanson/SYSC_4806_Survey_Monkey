package JpaApplication.Repository;

import JpaApplication.Model.Answer;
import JpaApplication.Model.QuestionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "questionTypes", path = "questionTypes")
public interface QuestionTypeRepository extends CrudRepository<QuestionType, Long> {

    QuestionType findById(long id);
    QuestionType findByType(QuestionType.TypeOfQuestion type);
}