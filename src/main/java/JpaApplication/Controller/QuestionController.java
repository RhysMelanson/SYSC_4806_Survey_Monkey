package JpaApplication.Controller;

import JpaApplication.Model.Question;
import JpaApplication.Repository.QuestionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class QuestionController {

    private final QuestionRepository repository;


    QuestionController(QuestionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/questions")
    List<Question> all() {
        return (List<Question>) repository.findAll();
    }
}
