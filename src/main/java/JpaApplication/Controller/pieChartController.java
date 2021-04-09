
package JpaApplication.Controller;

import JpaApplication.Model.*;
import JpaApplication.Repository.AnswerRepository;
import JpaApplication.Repository.QuestionRepository;
import JpaApplication.Repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Optional;
import java.util.Set;

@Controller
public class pieChartController {

    @Autowired
    private AnswerRepository repository;

    @RequestMapping("/pieChart")
    public String getData(Model model, @ModelAttribute Question question)
    {
        if(question.getQuestionType() instanceof MultipleChoice) {
            List<List<Object>> allData = new ArrayList<List<Object>>();
            List answers;
            answers = new ArrayList<>(question.getAnswers());
            for (int i = 0; i < answers.size(); i++) {
                List<Object> data = new ArrayList<Object>();
                data.add(answers.get(i).toString());
                data.add((repository.findByAnswerAndQuestion(answers.get(i).toString(), question)).size());
                allData.add(data);
            }
            model.addAttribute("pieData", allData);
        }
        return "pieChart";
    }
}
