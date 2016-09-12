/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package london.syntax.newsgeek;

import java.util.List;
import london.syntax.newsgeek.model.Post;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.rules.ExpectedException.none;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Rule
    public ExpectedException thrown = none();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class Application.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        Application.main(new String[]{"--posts", "99"});
    }

//    @Test
//    public void testRun() throws Exception {
//        System.out.println("main");
//        Application application = new Application();
//        application.run(new String[]{"--posts", "4"});
//    }
}
