package london.syntax.newsgeek.scraper.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import london.syntax.newsgeek.model.Post;
import london.syntax.newsgeek.model.entity.News;
import london.syntax.newsgeek.scraper.AbstractValidatingScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
@Service
public class HackerNewsScraper extends AbstractValidatingScraper {

    @Override
    protected final List<Post> scrapeInternal(int max) {
        List<Post> posts = new ArrayList<>(max);

        try {
            Document doc = Jsoup.connect("https://news.ycombinator.com/").get();

            Elements elements = doc.getElementsByClass("athing");

            for (Element element : elements) {
//                logger.debug(element);
                String id = element.attr("id");

                Element subtext = doc.getElementById("score_" + id);
                if (subtext == null) {
                    continue;
                }

                // Subtext doesn't have an id, so using the score's id to
                // correctly associate the headline row with the subtext row
                subtext = subtext.parent();

//                logger.debug(subtext);
                int score = 0;
                Element scoreElem = subtext.getElementById("score_" + id);
                try {
                    score = Integer.parseInt(scoreElem.text().split("\\D", 2)[0]);
                } catch (NumberFormatException e) {
                    logger.warn("Incorrect format for score [" + scoreElem + "]");
                    continue;
                }

                int comments = 0;
                Element commentElem = subtext.select("a:contains(comment)").first();
                try {
                    // Allow no comments to be found
                    if (commentElem != null) {
                        comments = Integer.parseInt(commentElem.text().split("\\D", 2)[0]);
                    }
                } catch (NumberFormatException e) {
                    logger.warn("Incorrect format for comment count [" + commentElem + "]");
                    continue;
                }

                int rank = 0;
                Element rankElem = element.getElementsByClass("rank").first();
                try {
                    rank = Integer.parseInt(rankElem.text().split("\\D", 2)[0]);
                } catch (NumberFormatException e) {
                    logger.warn("Incorrect format for rank [" + rankElem + "]");
                    continue;
                }

                String title = element.getElementsByClass("storylink").text();
                String uri = element.getElementsByClass("storylink").attr("href");
                String author = subtext.getElementsByClass("hnuser").text();

                News post = new News(score, comments, title, uri, author, rank);
                if (post.isValid()) {
                    posts.add(post);
                    
                    max--;
                    if (max < 1) {
                        break;
                    }
                } else {
                    logger.warn("Invalid post [" + post + "]. Skipping...");
                }
            }

        } catch (IOException e) {
            logger.error("Could not scrape HackerNews - probably connectivity issue", e);
        }

        return posts;
    }
}
