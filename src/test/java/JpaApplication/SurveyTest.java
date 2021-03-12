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
        QuestionInfo qi = new QuestionInfo("What is 2+2?");
        List<QuestionInfo> infos = new ArrayList<QuestionInfo>();
        infos.add(qi);
        Survey s = new Survey(infos);
        assertEquals(qi, s.getQuestionInfo(0));
    }
    @Test
    public void testAddQuestionInfo()
    {
        Survey s = new Survey();
        QuestionInfo qi = new QuestionInfo("What is 2+2?");
        s.addQuestionInfo(qi);
        assertEquals(qi, s.getQuestionInfo(0));
    }
    @Test
    public void testGetQuestionInfos1()
    {
        QuestionInfo qi = new QuestionInfo("What is 2+2?");
        QuestionInfo qi2 = new QuestionInfo("What is 3+3?");
        List<QuestionInfo> infos = new ArrayList<QuestionInfo>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey(infos);
        assertEquals(infos, s.getQuestionInfos());
    }
    @Test
    public void testGetQuestionInfos2()
    {
        QuestionInfo qi = new QuestionInfo("What is 2+2?");
        QuestionInfo qi2 = new QuestionInfo("What is 3+3?");
        List<QuestionInfo> infos = new ArrayList<QuestionInfo>();
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
        QuestionInfo qi = new QuestionInfo("What is 2+2?");
        QuestionInfo qi2 = new QuestionInfo("What is 3+3?");
        List<QuestionInfo> infos = new ArrayList<QuestionInfo>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey();
        s.setQuestionInfos(infos);
        assertEquals(infos, s.getQuestionInfos());
    }
    @Test
    public void testRemoveQuestionInfo()
    {
        QuestionInfo qi = new QuestionInfo("What is 2+2?");
        QuestionInfo qi2 = new QuestionInfo("What is 3+3?");
        List<QuestionInfo> infos = new ArrayList<QuestionInfo>();
        infos.add(qi);
        infos.add(qi2);
        Survey s = new Survey();
        s.setQuestionInfos(infos);
        s.removeQuestionInfo(0);
        assertEquals(1, s.getQuestionInfos().size());
    }
}
