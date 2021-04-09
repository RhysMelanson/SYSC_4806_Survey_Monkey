package JpaApplication.Controller;

import JpaApplication.Model.*;
import JpaApplication.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.*;
import java.util.List;

@Controller
public class HistogramController {

    @Autowired
    private AnswerRepository repository;

    @RequestMapping("/histogram")
    public String returnData(Model model, @ModelAttribute Question question){
        if(question.getQuestionType() instanceof NumberRange){

            List allData = new ArrayList<>();

            int numbers = question.getAnswersCount();
            Set<Answer> questionAnswer = question.getAnswers();
            Integer[] array = new Integer[questionAnswer.size()];
            int k = 0;
            for (Answer i: questionAnswer) {
                System.out.println(Integer.parseInt(i.getAnswer()));
                array[k++] = Integer.parseInt(i.getAnswer());
            }
            allData.add(numbers);
            allData.add(array);


//            for (int i = 0; i < numbers; i++) {
//                List<Object> data = new ArrayList<Object>();
//                data.add(value.get(i).toString());
//                data.add((repository.findByAnswerAndQuestion(value.get(i).toString(), question)).size());
//                allData.add(data);
//            }
            model.addAttribute("histData", allData);
        }
        return "histogram";
    }

}
