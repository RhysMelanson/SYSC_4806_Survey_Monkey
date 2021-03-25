
package JpaApplication;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
