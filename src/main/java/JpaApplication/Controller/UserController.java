
package JpaApplication.Controller;

import JpaApplication.Model.User;
import JpaApplication.Repository.UserNewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/addUser")
    public String addUserSubmit(@ModelAttribute User user, Model model)
    {
        model.addAttribute("user", user);

        repository.save(user);

        User u = repository.findByUserName(user.getUserName());
        return "created";
    }
}
