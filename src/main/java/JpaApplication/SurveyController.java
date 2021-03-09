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
    private QuestionInfoRepository QuestionRepo;

    @Autowired
    private SurveyRepository SurveyRepo;

    @GetMapping("/question")
    public String greetingForm(Model model) {
        model.addAttribute("question1", new QuestionInfo());
        return "question";
    }

    @PostMapping("/question")
    public String greetingSubmit(@ModelAttribute QuestionInfo questionInfo, Model model) {
        model.addAttribute("questionInfo", questionInfo);

        QuestionRepo.save(questionInfo);
//        model.save();
        return "result";
    }

}