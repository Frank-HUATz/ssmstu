import com.tan.dao.StudentDao;
import com.tan.pojo.StudentDO;
import com.tan.pojo.StudentVO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tan
 * @version 1.0.0
 * @ClassName test.java
 * @Description TODO
 * @createTime 2022-05-08 08:53:00
 */
public class test {

    private final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void t1() {
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");

        for (StudentVO s : studentDao.listStudentsAll()) {
            System.out.println(s);
        }

    }
}
