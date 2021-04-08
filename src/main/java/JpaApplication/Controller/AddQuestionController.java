package JpaApplication.Controller;

import JpaApplication.Model.*;
import JpaApplication.Repository.QuestionRepository;
import JpaApplication.Repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class AddQuestionController {


    @Autowired
    private QuestionRepository QuestionRepo;

    @Autowired
    private SurveyRepository SurveyRepo;

    private String surveyID;

    @GetMapping("/addQuestion")
    public String addQuestionForm(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
        surveyID = id;
        long ID = Long.parseLong(surveyID);
        Survey survey = SurveyRepo.findById(ID);
        model.addAttribute("questions", survey.getQuestions());
        model.addAttribute("question", new Question());
        model.addAttribute("openEnded", new OpenEnded());
        model.addAttribute("multipleChoice", new MultipleChoice());
        model.addAttribute("numberRange", new NumberRange());

        ArrayList<String> list = new ArrayList<String>();
        list.add("Open Ended Question");
        list.add("Multiple Choice Question");
        list.add("Range of Number Question");

        model.addAttribute("allValues", list);
        return "addQuestion";
    }

    @PostMapping("/addQuestion")
    public String addQuestionSubmit(@ModelAttribute Question question, @ModelAttribute OpenEnded openEnded,
                                    @ModelAttribute MultipleChoice multipleChoice, @ModelAttribute NumberRange numberRange,
                                    Model model) {
        long ID = Long.parseLong(surveyID);
        Survey survey = SurveyRepo.findById(ID);
        model.addAttribute("question", question);
        switch (question.getRadioButtonSelectedValue()) {
            case "Open Ended Question":
                model.addAttribute("questionType", openEnded);
                question.setQuestionType(openEnded);
                break;
            case "Multiple Choice Question":
                model.addAttribute("questionType", multipleChoice);
                question.setQuestionType(multipleChoice);
                break;
            case "Range of Number Question":
                model.addAttribute("questionType", numberRange);
                question.setQuestionType(numberRange);
                break;
        }
        question.setSurvey(survey);
        QuestionRepo.save(question);
        SurveyRepo.save(survey);
        return "redirect:/addQuestion?id=" + surveyID;
    }

//    @GetMapping("/addNumberRange")
//    public String addNumberRangeForm(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
//        surveyID = id;
//        Question question = new Question();
//        model.addAttribute("question", question);
//        model.addAttribute("numberRange", new NumberRange());
//        return "addNumberRange";
//    }
//
//    @PostMapping("/addNumberRange")
//    public String addNumberRangeSubmit(@ModelAttribute Question question, @ModelAttribute NumberRange questionType,
//                                       Model model) {
//        long ID = Long.parseLong(surveyID);
//        Survey survey = SurveyRepo.findById(ID);
//        question.setQuestionType(questionType);
//        question.setSurvey(survey);
//        model.addAttribute("question", question);
//        model.addAttribute("questionType", questionType);
//        QuestionRepo.save(question);
//        SurveyRepo.save(survey);
//        return "result";
//    }
}