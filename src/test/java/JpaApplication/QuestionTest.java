package JpaApplication;

import static org.junit.Assert.*;
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
        qi.setAnswer("Blue");
        assertEquals("Blue", qi.getAnswer());
    }
    @Test
    public void testToString(){
        Question qi = new Question("What colour is the sky?");
        qi.setAnswer("Blue");
        assertEquals("The answer to the Question: What colour is the sky? is: \nBlue", qi.toString());
    }

}
