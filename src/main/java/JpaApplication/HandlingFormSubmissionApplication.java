package JpaApplication;

import JpaApplication.Model.Answer;
import JpaApplication.Model.Question;
import JpaApplication.Model.Survey;
import JpaApplication.Repository.AnswerRepository;
import JpaApplication.Repository.QuestionRepository;
import JpaApplication.Repository.SurveyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HandlingFormSubmissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(HandlingFormSubmissionApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(QuestionRepository repo, SurveyRepository repository) {
        return args -> {
            Question quest = new Question("hi?");
            Answer ans1 = new Answer("this is the first answer");
            ans1.setQuestion(quest);
            Answer ans2 = new Answer("this is the second answer");
            ans2.setQuestion(quest);
            Survey surv = new Survey();
            surv.setName("name");
            quest.setSurvey(surv);
            repository.save(surv);
//            System.out.println(repo.findById(1).getAnswers());
            System.out.println(repository.findByName("name").getId());
            Survey survey1 = repository.findByName("name");
            System.out.println(repository.findByName("name").getQuestions());
        };
    }

}
