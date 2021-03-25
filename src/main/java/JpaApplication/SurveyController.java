package JpaApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


        SurveyRepo.save(test);
        SurveyRepo.save(test2);

        model.addAttribute("Surveys", SurveyRepo.findAll());
        model.addAttribute("Survey", new Survey());

        return "Surveys";
    }

    @PostMapping("/Surveys")
    public String SurveyListing(@ModelAttribute String sur, Model model) {
        System.out.println(sur + "k");

        //model.addAttribute("questionInfo", new Question());

        //QuestionRepo.save(questionInfo);
//        model.save();
        return "addQuestion";
    }

    @GetMapping("/ViewAnswers")
    public String ViewAnswer(Model model, Long ID) {
        ID = new Long(1);

        Optional<Long> optFoo = Optional.ofNullable( ID );
        long longFoo = optFoo.orElse( -1L );



        Question IHateMyLife = new Question("How are we doing today");
        IHateMyLife.addAnswer(new Answer("Terrible"));
        IHateMyLife.addAnswer(new Answer("Dieing on the inside"));
        IHateMyLife.addAnswer(new Answer("Lost the will to live"));
        Question IHateMyLife2 = new Question("How are we doing today");
        IHateMyLife2.addAnswer(new Answer("Terrible2"));
        IHateMyLife2.addAnswer(new Answer("Dieing on the inside2"));
        IHateMyLife2.addAnswer(new Answer("Lost the will to live2"));
        Survey test = new Survey();
        test.setId(1);
        test.addQuestionInfo(IHateMyLife);
        test.addQuestionInfo(IHateMyLife2);
        SurveyRepo.save(test);
        Survey ChosenSurvey = SurveyRepo.findById(longFoo);
        List<Question> quest = ChosenSurvey.getQuestionInfos();
        model.addAttribute("Questions", quest);

        return "ViewAnswers";
    }

}