package london.syntax.newsgeek.scraper.impl;

import london.syntax.genscraper.scraper.impl.HackerNewsScraper;
import java.util.List;
import london.syntax.genscraper.model.Post;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
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

        List<Post> posts = instance.scrapeInternal(10);
        assertNotNull("Posts should not be null", posts);

        System.out.println(posts.size());
        assertTrue("Should have scraped some posts", posts.size() > 0);

        posts.stream().forEach((post) -> {
            System.out.println(post);
        });
    }

}
