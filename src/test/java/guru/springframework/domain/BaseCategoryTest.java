package guru.springframework.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseCategoryTest {

    Category category;

    @BeforeClass
    public static void setUp1() {
        //category = new Category();
        System.out.println("BaseClass");
    }

    @Before
    public  void setUp1s() {
        //category = new Category();
        System.out.println("Before");
    }

    @After
    public  void setUp1ssjhvgvcx() {
        //category = new Category();
        System.out.println("After...");
    }
}
