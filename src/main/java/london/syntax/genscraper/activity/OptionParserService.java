package london.syntax.genscraper.activity;

import static java.util.Arrays.asList;
import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Class responsible for defining and parsing CLI options
 *
 * TODO: DTO to transfer back the options rather than a direct OptionSet as that
 * presumes the caller is aware of the implementation used here
 *
 * TODO: Interface perhaps? I'm not sure what other input medium there'd be at
 * this point other than CLI so leaving CLI only for now
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
@Service
public class OptionParserService {

    private int maxPosts;

    private final OptionParser parser;

    public OptionParserService() {

        // TODO: Bug here as the constructor is called before Spring bootstraps
        // Maxposts so the splash screen will say default 0 but the right value
        // is used once parse() is called. Probably just delegate this to a
        // non-constructor (injected would probably work best)
        // Workaround: Have hidden default value since it's profile based and more
        // of a limit than a user defined numbe
              
        parser = new OptionParser() {
            {
                acceptsAll(asList("p", "posts"), "max number of posts").withRequiredArg().ofType(Integer.class);
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

    @Value("${newsgeek.stories.max}")
    public final void setMaxPosts(int maxPosts) {
        this.maxPosts = maxPosts;
    }
}
