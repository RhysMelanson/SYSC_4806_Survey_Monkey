package JpaApplication.Repository;

import JpaApplication.Model.AllUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userCollection", path = "userCollection")
public interface AllUsersRepository extends CrudRepository<AllUsers, Long> {

    AllUsers findById(long id);
}
