package JpaApplication.Controller;

import JpaApplication.Repository.AnswerRepository;
import JpaApplication.Model.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
class AnswerController {

    private final AnswerRepository repository;


    AnswerController(AnswerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/answers")
    List<Answer> all() {
        return (List<Answer>) repository.findAll();
    }

    @GetMapping("/answerPieInfo")
    public String getData(Model model, @ModelAttribute Question question, @ModelAttribute String answer)
    {
        List<List<Object>> allData = new ArrayList<List<Object>>();
        List answers;
        answers = question.getAnswers();
        for(int i = 0;i<answers.size();i++)
        {
            List<Object> data = new ArrayList<Object>();
            data.add(answers.get(i));
            data.add(repository.findByAnswerAndQuestion(answer, question));
            allData.add(data);
        }
        model.addAttribute("pieData", allData);
        return "pieChart";
    }

}
