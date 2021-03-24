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