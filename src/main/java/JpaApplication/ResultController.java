package JpaApplication;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {

    @GetMapping("/result")
    public QuestionInfo resultForm(@RequestParam(value = "question") String question, Model model) {
        model.addAttribute("question1", question);
        return new QuestionInfo(question);
    }

    @PostMapping("/result")
    public QuestionInfo greetingSubmit(@ModelAttribute QuestionInfo questionInfo, Model model) {
        model.addAttribute("questionInfo", questionInfo);
        //return "result";
        return new QuestionInfo(questionInfo.getQuestion());
    }
}
