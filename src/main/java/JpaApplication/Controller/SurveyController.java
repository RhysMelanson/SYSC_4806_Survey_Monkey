package JpaApplication.Controller;

import JpaApplication.Model.*;
import JpaApplication.Repository.QuestionRepository;
import JpaApplication.Repository.SurveyRepository;
import JpaApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class SurveyController {


    @Autowired
    private QuestionRepository QuestionRepo;

    @Autowired
    private SurveyRepository SurveyRepo;

    @Autowired
    private UserRepository UserRepo;

    @GetMapping("/Surveys")
    public String SurveyList(@RequestParam(name="name", required=false, defaultValue="hassan") String username, Model model) {

        User user = UserRepo.findByUserName(username);

//        Survey test = new Survey();
//        test.setName("How much work do you do?");
//        Survey test2 = new Survey();
//        test2.setName("What your favorite ice cream?");
//
//        SurveyRepo.save(test);
//        SurveyRepo.save(test2);

        model.addAttribute("Surveys", user.getSurveys());

        return "Surveys";
    }


    @GetMapping("/ViewAnswers")
    public String ViewAnswer(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
        long ID = Long.parseLong(id);
        Question ChosenQuestion = QuestionRepo.findById(ID);
        model.addAttribute("Survey", ChosenQuestion.getSurvey());
        model.addAttribute("Answers", ChosenQuestion.getAnswers());
        switch (ChosenQuestion.getRadioButtonSelectedValue()) {
            case "Open-Ended Question":
                return "ViewOpenEndedAnswers";
            case "Multiple-Choice Question":
                model.addAttribute("MultipleChoice", ChosenQuestion.getQuestionType());
                model.addAttribute("question", ChosenQuestion);
                return "pieChart";
            case "Number-range Question":
                return "ViewNumberRangeAnswers";
        }
        return "ViewOpenEndedAnswers";
    }

    @GetMapping("/newSurvey")
    public String addSurvey(Model model){
        model.addAttribute("survey", new Survey());
        return "newSurvey";
    }

    @PostMapping("/newSurvey")
    public String addSurvey(@ModelAttribute Survey survey, Model model){
        model.addAttribute("survey", survey);
        SurveyRepo.save(survey);
        System.out.println(SurveyRepo.findAll());
        return "questionType";
    }

}