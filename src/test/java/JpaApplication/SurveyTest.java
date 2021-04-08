package JpaApplication;

import static org.junit.Assert.*;

import JpaApplication.Model.Question;
import JpaApplication.Model.Survey;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class SurveyTest {
    @Test
    public void testId(){
        Survey s = new Survey();
        s.setId(33);
        assertEquals(33, s.getId());
    }
    @Test
    public void testName()
    {
        Survey s = new Survey();
        s.setName("John");
        assertEquals("John", s.getName());
    }
    @Test
    public void testGetQuestionInfo()
    {
        Question qi = new Question("What is 2+2?");
        Set<Question> infos = new HashSet<Question>();
        infos.add(qi);
        Survey s = new Survey(infos);
        assertTrue(s.getQuestions().contains(qi));
    }
    @Test
    public void testAddQuestionInfo()
    {
        Survey s = new Survey();
        Question qi = new Question("What is 2+2?");
        s.addQuestions(qi);
        assertTrue(s.getQuestions().contains(qi));
    }
    @Test
    public void testGetQuestionInfos1()
    {
        Question qi = new Question("What is 2+2?");
        Question qi2 = new Question("What is 3+3?");
        Set<Question> infos = new HashSet<Question>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey(infos);
        assertEquals(infos, s.getQuestions());
    }
    @Test
    public void testGetQuestionInfos2()
    {
        Question qi = new Question("What is 2+2?");
        Question qi2 = new Question("What is 3+3?");
        Set<Question> infos = new HashSet<Question>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey();
        s.addQuestions(qi);
        s.addQuestions(qi2);
        assertEquals(infos, s.getQuestions());
    }
    @Test
    public void testSetQuestionInfos()
    {
        Question qi = new Question("What is 2+2?");
        Question qi2 = new Question("What is 3+3?");
        Set<Question> infos = new HashSet<Question>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey();
        s.setQuestions(infos);
        assertEquals(infos, s.getQuestions());
    }
    @Test
    public void testRemoveQuestionInfo()
    {
        Question qi = new Question("What is 2+2?");
        Question qi2 = new Question("What is 3+3?");
        Set<Question> infos = new HashSet<Question>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey();
        s.setQuestions(infos);
        s.removeQuestionInfo(qi);
        assertEquals(1, s.getQuestions().size());
    }
}
