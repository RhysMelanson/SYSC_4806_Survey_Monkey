
package JpaApplication.Controller;

import JpaApplication.Model.User;
import JpaApplication.Repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user")
    List<User> all() {
        return (List<User>) userRepo.findAll();
    }
//
//    @GetMapping("/addUser")
//    public String addUserForm(Model model)
//    {
//        model.addAttribute("user", new User());
//        return "login";
//    }
//    @PostMapping("/addUser")
//    public String addUserSubmit(@ModelAttribute User user, Model model)
//    {
//        model.addAttribute("user", user);
//        userRepo.save(user);
//        return "login";
//    }

    @GetMapping("/")
    public String loginCurrentUser(Model model)
    {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/")
    public String loginCurrentUser(@ModelAttribute User user, Model model)
    {
        User allUsers = userRepo.findByUserName(user.getUserName());
        if(allUsers == null){
            userRepo.save(user);
        }
//        model.addAttribute("username", user.getUserName());
        return "redirect:/Surveys?name=" + user.getUserName();
    }
}
