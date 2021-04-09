package JpaApplication.Controller;

import JpaApplication.Model.Question;
import JpaApplication.Repository.QuestionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/questions/{id}")
    Question one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
    }
}
