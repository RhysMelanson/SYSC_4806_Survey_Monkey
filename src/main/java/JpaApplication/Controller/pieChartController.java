package JpaApplication.Controller;

import JpaApplication.Model.*;
import JpaApplication.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class pieChartController {

    @Autowired
    private AnswerRepository repository;

    @GetMapping("/pieChart")
    public String getData(Model model, @ModelAttribute MultipleChoice MultipleChoice, @ModelAttribute Question question)
    {
        List<List<Object>> allData;
        String answer1 = MultipleChoice.getAnswer1();
        String answer2 = MultipleChoice.getAnswer2();
        String answer3 = MultipleChoice.getAnswer3();
        String answer4 = MultipleChoice.getAnswer4();
        int size1 = (repository.findByAnswerAndQuestion(answer1, question)).size();
        int size2 = (repository.findByAnswerAndQuestion(answer2, question)).size();
        int size3 = (repository.findByAnswerAndQuestion(answer3, question)).size();
        int size4 = (repository.findByAnswerAndQuestion(answer4, question)).size();
        List<Object> data = new ArrayList<Object>();
        data.add(answer1);
        data.add(size1);

        model.addAttribute("answer1", answer1);
        model.addAttribute("answer2", answer2);
        model.addAttribute("answer3", answer3);
        model.addAttribute("answer4", answer4);
        model.addAttribute("size1", 5);
        model.addAttribute("size2", size2);
        model.addAttribute("size3", size3);
        model.addAttribute("size4", size4);
        return "pieChart";
    }
}