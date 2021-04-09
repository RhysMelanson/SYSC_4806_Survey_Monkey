package JpaApplication;

import JpaApplication.Model.*;
import JpaApplication.Repository.AnswerRepository;
import JpaApplication.Repository.QuestionRepository;
import JpaApplication.Repository.SurveyRepository;
import JpaApplication.Repository.UserRepository;
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
            MultipleChoice qt = new MultipleChoice();
            qt.setAnswer1("First Answer");
            qt.setAnswer2("Second Answer");
            qt.setAnswer3("Third Answer");
            qt.setAnswer4("Fourth Answer");
            qt.setQuestion(quest);
            quest.setQuestionType(qt);
            System.out.println(quest.getRadioButtonSelectedValue());
            for (int i = 0; i < 20; i++) {
                Answer ans1 = new Answer("First Answer");
                ans1.setQuestion(quest);
                Answer ans2 = new Answer("Second Answer");
                ans2.setQuestion(quest);
                Answer ans3 = new Answer("Third Answer");
                ans3.setQuestion(quest);
                Answer ans4 = new Answer("Fourth Answer");
                ans4.setQuestion(quest);
            }



//          Creating a survey with its question
            Survey surv = new Survey();
            surv.setName("name");
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
