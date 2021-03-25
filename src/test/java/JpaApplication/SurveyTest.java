package JpaApplication;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

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
        List<Question> infos = new ArrayList<Question>();
        infos.add(qi);
        Survey s = new Survey(infos);
        assertEquals(qi, s.getQuestionInfo(0));
    }
    @Test
    public void testAddQuestionInfo()
    {
        Survey s = new Survey();
        Question qi = new Question("What is 2+2?");
        s.addQuestionInfo(qi);
        assertEquals(qi, s.getQuestionInfo(0));
    }
    @Test
    public void testGetQuestionInfos1()
    {
        Question qi = new Question("What is 2+2?");
        Question qi2 = new Question("What is 3+3?");
        List<Question> infos = new ArrayList<Question>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey(infos);
        assertEquals(infos, s.getQuestionInfos());
    }
    @Test
    public void testGetQuestionInfos2()
    {
        Question qi = new Question("What is 2+2?");
        Question qi2 = new Question("What is 3+3?");
        List<Question> infos = new ArrayList<Question>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey();
        s.addQuestionInfo(qi);
        s.addQuestionInfo(qi2);
        assertEquals(infos, s.getQuestionInfos());
    }
    @Test
    public void testSetQuestionInfos()
    {
        Question qi = new Question("What is 2+2?");
        Question qi2 = new Question("What is 3+3?");
        List<Question> infos = new ArrayList<Question>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey();
        s.setQuestionInfos(infos);
        assertEquals(infos, s.getQuestionInfos());
    }
    @Test
    public void testRemoveQuestionInfo()
    {
        Question qi = new Question("What is 2+2?");
        Question qi2 = new Question("What is 3+3?");
        List<Question> infos = new ArrayList<Question>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey();
        s.setQuestionInfos(infos);
        s.removeQuestionInfo(0);
        assertEquals(1, s.getQuestionInfos().size());
    }
}
