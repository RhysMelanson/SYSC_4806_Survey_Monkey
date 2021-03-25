package JpaApplication;

import static org.junit.Assert.*;

import JpaApplication.Model.Answers.Answer;
import JpaApplication.Model.Answers.OpenEnded;
import JpaApplication.Model.Question;
import org.junit.Test;

public class QuestionTest {
    @Test
    public void testId(){
        Question qi = new Question();
        qi.setId(52);
        assertEquals(52, qi.getId());
    }
    @Test
    public void testGetQuestion(){
        Question qi = new Question("What colour is the sky?");
        assertEquals("What colour is the sky?", qi.getQuestions());
    }
    @Test
    public void testSetQuestion1(){
        Question qi = new Question();
        qi.setQuestions("What is 2+2?");
        assertEquals("What is 2+2?", qi.getQuestions());
    }
    @Test
    public void testSetQuestion2(){
        Question qi = new Question("What colour is the sky?");
        qi.setQuestions("What is 2+2?");
        assertEquals("What is 2+2?", qi.getQuestions());
    }
    @Test
    public void testAnswer(){
        Question qi = new Question("What colour is the sky?");
        Answer ans = new OpenEnded("Blue");
        qi.addAnswer(ans);
        assertEquals("Blue", qi.getAnswer(0).toString());
    }
    @Test
    public void testToString(){
        Question qi = new Question("What colour is the sky?");
        Answer ans = new OpenEnded("Blue");
        qi.addAnswer(ans);
        Answer ans1 = new OpenEnded("Blue");
        qi.addAnswer(ans1);
        assertEquals("What colour is the sky? : \n" + "1 | Blue\n" + "2 | Blue\n", qi.toString());
    }

}
