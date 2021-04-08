package JpaApplication.Controller;

import JpaApplication.Model.User;
import JpaApplication.Repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class UserBackendController {

    private final UserRepository repository;


    UserBackendController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return (List<User>) repository.findAll();
    }
}
