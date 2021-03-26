package JpaApplication;

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



    @GetMapping("/addQuestion")
    public String addQuestionForm(Model model) {
        model.addAttribute("question", new Question());
        return "addQuestion";
    }

    @PostMapping("/addQuestion")
    public String addQuestionSubmit(@ModelAttribute Question question, Model model) {
        model.addAttribute("question", question);
        Answer answer = new Answer("answer");
        question.setAnswersByType("Open-Ended");
        question.addAnswer(answer);
//
        QuestionRepo.save(question);

        Question q1 = QuestionRepo.findByQuestions(question.getQuestions());
        System.out.println(q1);

        return "result";
    }

    @GetMapping("/Surveys")
    public String SurveyList(Model model) {

        Survey test = new Survey();
        test.setName("How much work do you do?");
        Survey test2 = new Survey();
        test2.setName("What your favorite ice cream?");
        /*
        Question IHateMyLife = new Question("How are we doing today");
        IHateMyLife.addAnswer(new Answer("Terrible"));
        IHateMyLife.addAnswer(new Answer("Dieing on the inside"));
        IHateMyLife.addAnswer(new Answer("Lost the will to live"));
        Question IHateMyLife2 = new Question("How are we doing today");
        IHateMyLife2.addAnswer(new Answer("Terrible2"));
        IHateMyLife2.addAnswer(new Answer("Dieing on the inside2"));
        IHateMyLife2.addAnswer(new Answer("Lost the will to live2"));
        //Survey test3 = new Survey();
        //test3.setName("How much do you hate your life?");
        test.addQuestionInfo(IHateMyLife);
        test.addQuestionInfo(IHateMyLife2);
        //SurveyRepo.save(test3);


*/
        SurveyRepo.save(test);
        SurveyRepo.save(test2);

        model.addAttribute("Surveys", SurveyRepo.findAll());
        model.addAttribute("Survey", new Survey());

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

}