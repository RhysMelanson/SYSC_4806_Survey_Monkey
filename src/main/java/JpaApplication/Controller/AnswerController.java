package JpaApplication.Controller;

import JpaApplication.Model.Answers.Answer;
import JpaApplication.Repository.AnswerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
