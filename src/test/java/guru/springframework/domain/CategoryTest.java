package guru.springframework.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jt on 6/17/17.
 */
public class CategoryTest extends BaseCategoryTest {

    Category category;

    @BeforeClass
    public static void setUp2() {
        //category = new Category();
        System.out.println("Derived BeforecLass");
    }

    @Before
    public void setUp() {
        category = new Category();
        System.out.println("Derived Before");
    }

    @After
    public  void setUp1ss() {
        category = null;
        System.out.println("Derived After");
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void getRecipes() throws Exception {
    }

}