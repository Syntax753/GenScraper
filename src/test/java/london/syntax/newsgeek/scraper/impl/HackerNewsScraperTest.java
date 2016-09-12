package london.syntax.newsgeek.scraper.impl;

import java.util.List;
import london.syntax.newsgeek.model.Post;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public class HackerNewsScraperTest {

    public HackerNewsScraperTest() {
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
     * Test of scrapeInternal method, of class HackerNewsScraper.
     */
    @Test
    public void testScrapeInternal() {
        System.out.println("scrapeInternal");
        HackerNewsScraper instance = new HackerNewsScraper();

        List<Post> posts = instance.scrapeInternal();
        assertNotNull("Posts should not be null", posts);

        System.out.println(posts.size());
        assertTrue("Should have scraped some posts", posts.size() > 0);

        posts.stream().forEach((post) -> {
            System.out.println(post);
        });
    }

}
