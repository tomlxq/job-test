import com.tom.jdbc.Student;
import com.tom.jdbc.StudentJDBCTemplate;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by tom on 2016/5/5.
 */
public class 学生JDBC测试 extends BaseTest {

    @Test
    public void test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("student-jdbc.xml");

        StudentJDBCTemplate template =
                (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
        template.createTable();
        System.out.println("------Records Creation--------" );
        template.create("Zara", 11);
        template.create("Nuha", 2);
        template.create("Ayan", 15);

        System.out.println("------Listing Multiple Records--------" );
        List<Student> students = template.listStudents();
        for (Student record : students) {
            logger.debug("{}",record);
        }

        System.out.println("----Updating Record with ID = 2 -----" );
        template.update(2, 20);

        System.out.println("----Listing Record with ID = 2 -----" );
        Student student = template.getStudent(2);
        logger.debug("{}",student);
    }
}
