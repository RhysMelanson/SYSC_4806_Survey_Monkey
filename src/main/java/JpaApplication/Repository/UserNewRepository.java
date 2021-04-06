package JpaApplication.Repository;

import JpaApplication.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserNewRepository extends CrudRepository<User, Long> {

    User findById(long id);
    User findByUserName(String userName);
}
