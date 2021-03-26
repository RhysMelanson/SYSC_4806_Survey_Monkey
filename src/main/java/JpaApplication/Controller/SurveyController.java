package JpaApplication.Controller;

import JpaApplication.Model.Answer;
import JpaApplication.Model.Question;
import JpaApplication.Model.Survey;
import JpaApplication.Repository.QuestionRepository;
import JpaApplication.Repository.SurveyRepository;
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

    @GetMapping("/questionType")
    public String chooseQuestionType(Model model) {
        model.addAttribute("question", new Question());
        return "questionType";
    }

    @GetMapping("/addQuestion")
    public String addQuestionForm(Model model) {
        model.addAttribute("question", new Question());
        return "addQuestion";
    }

    @PostMapping("/addQuestion")
    public String addQuestionSubmit(@ModelAttribute Question question, Model model) {
        model.addAttribute("question", question);
        question.setQuestionType(0);
        QuestionRepo.save(question);
        return "result";
    }

    @GetMapping("/addMultipleChoices")
    public String addMultipleChoicesForm(Model model) {
        model.addAttribute("question", new Question());
        return "addMultipleChoices";
    }

    @PostMapping("/addMultipleChoices")
    public String addMultipleChoicesSubmit(@ModelAttribute Question question, Model model) {
        model.addAttribute("question", question);
        question.setQuestionType(1);
        QuestionRepo.save(question);
        return "result";
    }

    @GetMapping("/addNumberRange")
    public String addNumberRangeForm(Model model) {
        model.addAttribute("question", new Question());
        return "addNumberRange";
    }

    @PostMapping("/addNumberRange")
    public String addNumberRangeSubmit(@ModelAttribute Question question, Model model) {
        model.addAttribute("question", question);
        question.setQuestionType(2);
        QuestionRepo.save(question);
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
        model.addAttribute("questionInfo", new Question());

        //QuestionRepo.save(questionInfo);
//        model.save();
        return "result";
    }



}