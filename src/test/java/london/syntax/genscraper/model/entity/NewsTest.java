package london.syntax.genscraper.model.entity;

import london.syntax.genscraper.model.entity.News;
import java.util.ArrayList;
import java.util.List;
import london.syntax.genscraper.exception.ScraperValidationException;
import london.syntax.genscraper.model.Post;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class NewsTest {

    private List<Post> posts = new ArrayList<>();

    Post badPoints = new News("Title", "http://google.com", "", 1, "Author", -1,1);
//    Post badComments = 
//    Post badTitle = 
//    Post badUri = 
//    Post badAuthor = 
//    Post badRank = 

    public NewsTest() {
    }

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
     * Test of getPoints method, of class News.
     */
    @Test(expected = ScraperValidationException.class)
    public void testGetPoints() {
        System.out.println("getPoints");
        assertFalse(badPoints.isValid());
        badPoints.validate();
    }

    /**
     * Test of getComments method, of class News.
     */
    @Test(expected = ScraperValidationException.class)
    public void testGetComments() {
        System.out.println("getComments");
        assertFalse(badComments.isValid());
        badComments.validate();
    }

    /**
     * Test of getTitle method, of class News.
     */
    @Test(expected = ScraperValidationException.class)
    public void testGetTitle() {
        System.out.println("getTitle");
        assertFalse(badTitle.isValid());
        badTitle.validate();
    }

    /**
     * Test of getUri method, of class News.
     */
    @Test(expected = ScraperValidationException.class)
    public void testGetUri() {
        System.out.println("getUri");
        assertFalse(badUri.isValid());
        badUri.validate();
    }

    /**
     * Test of getAuthor method, of class News.
     */
    @Test(expected = ScraperValidationException.class)
    public void testGetAuthor() {
        System.out.println("getAuthor");
        assertFalse(badAuthor.isValid());
        badAuthor.validate();
    }

    /**
     * Test of getRank method, of class News.
     */
    @Test(expected = ScraperValidationException.class)
    public void testGetRank() {
        System.out.println("getRank");
        assertFalse(badRank.isValid());
        badRank.validate();
    }

}
