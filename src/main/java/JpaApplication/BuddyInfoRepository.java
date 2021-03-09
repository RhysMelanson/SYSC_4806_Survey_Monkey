package JpaApplication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddyinfo", path = "buddyinfo")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    BuddyInfo findById(long id);
    BuddyInfo findByName(String name);
}