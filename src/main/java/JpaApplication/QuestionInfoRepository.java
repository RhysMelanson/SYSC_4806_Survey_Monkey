package JpaApplication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "questioninfo", path = "questioninfo")
public interface QuestionInfoRepository extends CrudRepository<QuestionInfo, Long> {

    QuestionInfo findById(long id);
    QuestionInfo findByQuestion(String question);
}