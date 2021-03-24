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

    @GetMapping("/Surveys")
    public String SurveyList(Model model) {

        Survey test = new Survey();
        test.setName("How much work do you do?");
        Survey test2 = new Survey();
        test2.setName("What your favorite ice cream?");


        SurveyRepo.save(test);
        SurveyRepo.save(test2);

        model.addAttribute("Surveys", SurveyRepo.findAll());

        return "Surveys";
    }

    @PostMapping("/Surveys")
    public String SurveyListing(@ModelAttribute Survey sur, Model model) {
        System.out.println(sur.getId());
        model.addAttribute("questionInfo", new QuestionInfo());

        //QuestionRepo.save(questionInfo);
//        model.save();
        return "result";
    }



}