package JpaApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuddyController {

    @GetMapping("/buddy")
    public String greetingForm(Model model) {
        model.addAttribute("buddy1", new BuddyInfo());
        return "buddy";
    }

    @PostMapping("/buddy")
    public String greetingSubmit(@ModelAttribute BuddyInfo buddy, Model model) {
        model.addAttribute("buddy", buddy);
//        model.save();
        return "result";
    }

}