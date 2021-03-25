package JpaApplication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userNew", path = "userNew")
public interface UserNewRepository extends CrudRepository<User, Long> {

    User findById(long id);
    User findByUserName(String userName);
}
