package london.syntax.newsgeek;

import static java.util.Arrays.asList;
import java.util.List;
import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import london.syntax.newsgeek.model.Post;
import london.syntax.newsgeek.scraper.ValidatingScraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application entry point
 *
 * Uses SpringBoot to simplify Spring configuration
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${newsgeek.stories.max}")
    private int maxPosts;

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private ValidatingScraper hackerNewsScraper;

    @Override
    public void run(String... args) throws Exception {
        logger.debug("Initialising newsgeek...");

        OptionSet options = parse(args);

        if (options != null) {
            logger.debug("Scraping max [" + options.valueOf("p") + "]");
            List<Post> posts = hackerNewsScraper.scrape((Integer) options.valueOf("p"));
            System.out.println(hackerNewsScraper.asJson(posts));
        }
    }

    private OptionSet parse(String... args) throws Exception {
        OptionSet ret = null;

        OptionParser parser = new OptionParser() {
            {
                acceptsAll(asList("p", "posts"), "max number of posts").withRequiredArg().ofType(Integer.class).defaultsTo(maxPosts);
                acceptsAll(asList("h", "?"), "show help").forHelp();
            }
        };

        try {
            OptionSet options = parser.parse(args);
            if (options.has("h")) {
                parser.printHelpOn(System.err);
            } else {
                ret = options;
            }
        } catch (OptionException e) {
            parser.printHelpOn(System.err);
        }

        return ret;
    }

    /**
     * Main entry point. SpringBoot will initialise the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    public void setHackerNewsScraper(ValidatingScraper hackerNewsScraper) {
        this.hackerNewsScraper = hackerNewsScraper;
    }
}
