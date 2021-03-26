package JpaApplication.Controller;

import JpaApplication.Repository.AllUsersRepository;
import JpaApplication.Model.AllUsers;
import JpaApplication.Model.User;
import JpaApplication.Repository.UserNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AllUsersController {


    @Autowired
    private UserNewRepository UserNewRepo;

    @Autowired
    private AllUsersRepository AllUsersRepo;

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User(""));
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUserSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

        UserNewRepo.save(user);

       User u = UserNewRepo.findByUserName(user.getUserName());
       System.out.println(u);

        return "created";
    }

    @GetMapping("/AllUser")
    public String UserLogin(Model model) {

        AllUsers AU = new AllUsers();
        AllUsersRepo.save(AU);

        model.addAttribute("AllUser", AllUsersRepo.findAll());

        return "AllUser";
    }

    @PostMapping("/AllUser")
    public String UserLoggedIn(@ModelAttribute User user, Model model) {
        AllUsers au = AllUsersRepo.findById(0);
        System.out.println(au.getId());
        au.login(user.getUserName());

        model.addAttribute("user", au.getUsers().get(0));

        return "logged";
    }



}
