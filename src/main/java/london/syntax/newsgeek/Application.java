package london.syntax.newsgeek;

import com.google.gson.Gson;
import java.util.List;
import london.syntax.newsgeek.model.Post;
import london.syntax.newsgeek.scraper.ValidatingScraper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(Application.class);

    private ValidatingScraper hackerNewsScraper;

    @Override
    public void run(String... args) throws Exception {
        logger.debug("Initialising newsgeek...");

        if (parse()) {
            List<Post> posts = hackerNewsScraper.scrape();

            logger.info(new Gson().toJson(posts));

        }
    }

    private boolean parse() {
        boolean success = false;

        success = true;

        return success;
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
