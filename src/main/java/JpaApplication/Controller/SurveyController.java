package JpaApplication.Controller;

import JpaApplication.Model.*;
import JpaApplication.Repository.QuestionRepository;
import JpaApplication.Repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        model.addAttribute("openEnded", new OpenEnded());
        return "addQuestion";
    }

    @PostMapping("/addQuestion")
    public String addQuestionSubmit(@ModelAttribute Question question, @ModelAttribute OpenEnded questionType,
                                    Model model) {
        model.addAttribute("question", question);
        model.addAttribute("questionType", questionType);
        question.setQuestionType(questionType);
        QuestionRepo.save(question);
        return "result";
    }

    @GetMapping("/addMultipleChoices")
    public String addMultipleChoicesForm(Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("multipleChoice", new MultipleChoice());
        return "addMultipleChoices";
    }

    @PostMapping("/addMultipleChoices")
    public String addMultipleChoicesSubmit(@ModelAttribute Question question, @ModelAttribute MultipleChoice questionType,
                                           Model model) {
        model.addAttribute("question", question);
        model.addAttribute("questionType", questionType);
        question.setQuestionType(questionType);
        QuestionRepo.save(question);
        return "result";
    }

    @GetMapping("/addNumberRange")
    public String addNumberRangeForm(Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("numberRange", new NumberRange());
        return "addNumberRange";
    }

    @PostMapping("/addNumberRange")
    public String addNumberRangeSubmit(@ModelAttribute Question question, @ModelAttribute NumberRange questionType,
                                       Model model) {
        model.addAttribute("question", question);
        model.addAttribute("questionType", questionType);
        question.setQuestionType(questionType);
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


    @GetMapping("/ViewAnswers")
    public String ViewAnswer(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
        //System.out.println(id);
        long ID = Long.parseLong(id);

        System.out.println(SurveyRepo.findAll());
        Survey ChosenSurvey = SurveyRepo.findById(ID);
        //System.out.println(ChosenSurvey);
       // System.out.println(ChosenSurvey.getName());
        //System.out.println(ChosenSurvey.getId());

        List<Question> quest = ChosenSurvey.getQuestionInfos();
        System.out.println(quest);
        model.addAttribute("Questions", quest);

        return "ViewAnswers";
    }
    
    @GetMapping("/answerQuestions")
    public String answerForm(Model model, Question question) {
        model.addAttribute("question", new Question());
        QuestionRepo.save(question);

        Question q1 = QuestionRepo.findByQuestions(question.getQuestions());
        System.out.println(q1);
        return "answerQuestions";
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
