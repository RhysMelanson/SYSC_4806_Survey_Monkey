package JpaApplication.Controller;

import JpaApplication.Model.Survey;
import JpaApplication.Repository.SurveyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class SurveyBackendController {

    private final SurveyRepository repository;


    SurveyBackendController(SurveyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/survey")
    List<Survey> all() {
        return (List<Survey>) repository.findAll();
    }
}
