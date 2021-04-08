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

}
