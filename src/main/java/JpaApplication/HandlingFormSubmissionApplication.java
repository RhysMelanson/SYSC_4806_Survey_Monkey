package JpaApplication;

import JpaApplication.Model.*;
import JpaApplication.Repository.AnswerRepository;
import JpaApplication.Repository.QuestionRepository;
import JpaApplication.Repository.SurveyRepository;
import JpaApplication.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import JpaApplication.Model.*;
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
    CommandLineRunner runner(AnswerRepository repo, UserRepository repository) {
        return args -> {
//          Creating a question with answers
            Question quest = new Question("hi?");
            Answer ans1 = new Answer("this is the first answer");
            ans1.setQuestion(quest);
            Answer ans2 = new Answer("this is the first answer");
            ans2.setQuestion(quest);
            quest.setQuestionType(new OpenEnded());

//          Creating a survey with its question
            Survey surv = new Survey();
            surv.setName("name");
            surv.setState(true);
            quest.setSurvey(surv);

//          Creating a user with its question
            User user = new User("hassan");
            surv.setUser(user);

            repository.save(user);
//            System.out.println(repo.findByAnswerAndQuestion("this is the first answer", quest));
//            System.out.println(repository.findByName("name").getId());
//            Survey survey1 = repository.findByName("name");
//            System.out.println(repository.findByName("name").getQuestions());
        };
    }

}
