package london.syntax.genscraper;

import java.util.List;
import joptsimple.OptionSet;
import london.syntax.genscraper.activity.OptionParserService;
import london.syntax.genscraper.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import london.syntax.genscraper.scraper.Scraper;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;

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

    private Scraper hackerNewsScraper;
    private OptionParserService optionProvider;

    @Override
    public void run(String... args) throws Exception {
        logger.debug("Initialising genscraper via cli...");
        optionProvider.showHelp();

        OptionSet options = optionProvider.parse(args);
        // Using null instead of handling exceptions in this case
        if (options != null) {
            // make sure user hasn't specified more than the maximum set by the profile
            int choice = (Integer) options.valueOf("p");
            if (choice == 0) {
                choice = optionProvider.getMaxPosts();
            } else {
                choice = Math.min(choice, optionProvider.getMaxPosts());
            }

            System.err.println("Scraping max [" + choice + "] posts from [" + options.valueOf("p") + "," + optionProvider.getMaxPosts() + "]");
            List<Post> posts = hackerNewsScraper.scrape(choice);

            // Only using System.out for the result. The rest is either System.err
            // for console display such as usage or will be handled by a Logger and appended to a file
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
    public void setHackerNewsScraper(Scraper hackerNewsScraper) {
        this.hackerNewsScraper = hackerNewsScraper;
    }

    @Autowired
    public void setOptionProvider(OptionParserService optionProvider) {
        this.optionProvider = optionProvider;
    }

    // jsr-303/439
    @Bean
    public Validator validator() {
        return new org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
    }
}
