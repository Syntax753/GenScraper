package london.syntax.newsgeek.parser;

import static java.util.Arrays.asList;
import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Helper service to provide available options
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
@Service
public class OptionProvider {

    @Value("${newsgeek.stories.max}")
    private final int maxPosts = 17;

    private final OptionParser parser;

    public OptionProvider() {
        parser = new OptionParser() {
            {
                acceptsAll(asList("p", "posts"), "max number of posts").withRequiredArg().ofType(Integer.class).defaultsTo(maxPosts);
                acceptsAll(asList("h", "?"), "show help").forHelp();
            }
        };
    }

    public OptionSet parse(String... args) throws Exception {
        OptionSet ret = null;

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

    public void showHelp() throws Exception {
        parser.printHelpOn(System.err);
    }
    
    public int getMaxPosts() {
        return maxPosts;
    }

}
