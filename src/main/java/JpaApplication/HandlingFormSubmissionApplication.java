package JpaApplication;

import JpaApplication.Model.Answer;
import JpaApplication.Model.OpenEnded;
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
    CommandLineRunner runner(AnswerRepository repo, SurveyRepository repository) {
        return args -> {
            Question quest = new Question("hi?");
            Answer ans1 = new Answer("this is the first answer");
            ans1.setQuestion(quest);
            Answer ans2 = new Answer("this is the first answer");
            ans2.setQuestion(quest);
            Survey surv = new Survey();
            surv.setName("name");
            quest.setSurvey(surv);
            quest.setQuestionType(new OpenEnded());
            repository.save(surv);
            System.out.println(repo.findByAnswerAndQuestion("this is the first answer", quest));
//            System.out.println(repository.findByName("name").getId());
//            Survey survey1 = repository.findByName("name");
//            System.out.println(repository.findByName("name").getQuestions());
        };
    }

}
