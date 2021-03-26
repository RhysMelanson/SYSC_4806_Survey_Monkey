
package JpaApplication.Controller;

import JpaApplication.Model.User;
import JpaApplication.Repository.UserNewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class UserController {

    private final UserNewRepository repository;


    UserController(UserNewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user")
    List<User> all() {
        return (List<User>) repository.findAll();
    }
}
