package JpaApplication.Controller;

import JpaApplication.Model.*;
import JpaApplication.Repository.QuestionRepository;
import JpaApplication.Repository.SurveyRepository;
import JpaApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

        Iterable<Survey> Surveys = SurveyRepo.findAll();
        ArrayList<Survey> survs = new ArrayList<Survey>();



        for(Survey s: Surveys){

            if(s.getUser() == user || s.getState() == true){
                //then just add the if open statement
                
                survs.add(s);
            }
        }




        model.addAttribute("user", user.getUserName());
        model.addAttribute("Surveys", survs);

        return "Surveys";
    }


    @GetMapping("/ViewAnswers")
    public String ViewAnswer(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
        //System.out.println(id);
        long ID = Long.parseLong(id);


        Survey ChosenSurvey = SurveyRepo.findById(ID);
        //System.out.println(ChosenSurvey);
       // System.out.println(ChosenSurvey.getName());
        //System.out.println(ChosenSurvey.getId());

        Set<Question> quest = ChosenSurvey.getQuestions();

        model.addAttribute("Survey", ChosenSurvey);
        model.addAttribute("Questions", quest);
        model.addAttribute("Open", new OpenEnded());

        return "ViewAnswers";
    }

    @PostMapping("/ViewAnswers")
    public String ViewAnswer(@RequestParam(name="id", required=false, defaultValue="1") int id, Model model) {
        long ID = id;
        Survey surv = SurveyRepo.findById(ID);
        surv.setState(false);
        SurveyRepo.save(surv);


        model.addAttribute("survey", new Survey());
        return "newSurvey";
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