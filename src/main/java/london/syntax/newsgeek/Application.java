package london.syntax.newsgeek;

import java.util.List;
import joptsimple.OptionSet;
import london.syntax.newsgeek.parser.OptionProvider;
import london.syntax.newsgeek.model.Post;
import london.syntax.newsgeek.scraper.ValidatingScraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private ValidatingScraper hackerNewsScraper;
    private OptionProvider optionProvider;

    @Override
    public void run(String... args) throws Exception {
        logger.debug("Initialising newsgeek...");
        optionProvider.showHelp();

        OptionSet options = optionProvider.parse(args);
        if (options != null) {
            int trueMax = Math.min((Integer) options.valueOf("p"), optionProvider.getMaxPosts());
            System.err.println("Scraping max [" + trueMax + "] from [" + options.valueOf("p") + "," + optionProvider.getMaxPosts() + "]");
            List<Post> posts = hackerNewsScraper.scrape(trueMax);
            System.out.println(hackerNewsScraper.asJson(posts));
        }
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

    @Autowired
    public void setOptionProvider(OptionProvider optionProvider) {
        this.optionProvider = optionProvider;
    }
}
