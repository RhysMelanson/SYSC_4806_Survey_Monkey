package JpaApplication;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuestionInfoTest {
    @Test
    public void testId(){
        QuestionInfo qi = new QuestionInfo();
        qi.setId(52);
        assertEquals(52, qi.getId());
    }
    @Test
    public void testGetQuestion(){
        QuestionInfo qi = new QuestionInfo("What colour is the sky?");
        assertEquals("What colour is the sky?", qi.getQuestion());
    }
    @Test
    public void testSetQuestion1(){
        QuestionInfo qi = new QuestionInfo();
        qi.setQuestion("What is 2+2?");
        assertEquals("What is 2+2?", qi.getQuestion());
    }
    @Test
    public void testSetQuestion2(){
        QuestionInfo qi = new QuestionInfo("What colour is the sky?");
        qi.setQuestion("What is 2+2?");
        assertEquals("What is 2+2?", qi.getQuestion());
    }
    @Test
    public void testAnswer(){
        QuestionInfo qi = new QuestionInfo("What colour is the sky?");
        qi.setAnswer("Blue");
        assertEquals("Blue", qi.getAnswer());
    }
    @Test
    public void testToString(){
        QuestionInfo qi = new QuestionInfo("What colour is the sky?");
        qi.setAnswer("Blue");
        assertEquals("The answer to the Question: What colour is the sky? is: \nBlue", qi.toString());
    }

}
