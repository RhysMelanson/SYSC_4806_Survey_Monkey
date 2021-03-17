package JpaApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SurveyController {


    @Autowired
    private QuestionRepository QuestionRepo;

    @Autowired
    private SurveyRepository SurveyRepo;

    @GetMapping("/addQuestion")
    public String addQuestionForm(Model model) {
        model.addAttribute("question", new Question());
        return "addQuestion";
    }

    @PostMapping("/addQuestion")
    public String addQuestionSubmit(@ModelAttribute Question question, Model model) {
        model.addAttribute("question", question);

        QuestionRepo.save(question);
//        model.save();
        return "result";
    }

}