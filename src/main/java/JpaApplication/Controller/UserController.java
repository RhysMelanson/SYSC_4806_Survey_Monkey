
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

    private final UserNewRepository userRepo;


    UserController(UserNewRepository repository) {
        this.userRepo = repository;
    }

    @GetMapping("/user")
    List<User> all() {
        return (List<User>) userRepo.findAll();
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model)
    {
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/addUser")
    public String addUserSubmit(@ModelAttribute User user, Model model)
    {
        model.addAttribute("user", user);
        userRepo.save(user);
        return "login";
    }
    @GetMapping("/loginUser")
    public String loginCurrentUser(@ModelAttribute String userName, Model model)
    {
        System.out.println(userRepo.findAll());
        User loggedUser = userRepo.findByUserName(userName);

        model.addAttribute("user", loggedUser);

        return "login";
    }
}
