#  NewsGeek #

## About ##
CLI News aggregator currently just focused on top stories on hackernews.com

## Usage ##
Example to fetch the top 10 stories:
> newsgeek --posts 10

## Releases ##
First planned release will be 0.1

### v0.2 (future release) ###
* Async connection to remove the 100 limit by throttling the scraping
* Offset option for easy paging
* Date offset (fetch all stories since 01/Sep/2016 for example)
* Ensure current UID check is indeed 3986 compliant
 
### v0.1 (next release) ###
Top stories fetched from Hacker News and output as JSON

## Options ##
> --posts N, -p N

* number N of stories to fetch

> -?, -h

* display these options

## Dependencies ##
### Jars ###
* spring-boot - provides the bom for required deps and starter dependency management poms for bundled deps
* spring-boot-starter-test - helps with regression/unit tests but not made full us of it yet
* org.jsoup - best (in my opinion) for DOM access esp wit malformed html
* net.sf.jopt-simple - only used minor functionality for the option parsing
* com.google.code.gson - best there is for Json reflection. Jackson wins the other accolades
* spring - only used for DI really (core and context) with some Spring boot deps too
* logback - settled for the Spring default rather than spend too much time on Maven Spring exclusions

### Plugins ###
* spotify maven-docker-plugin - untested as can't get this completing on ARM
* spring-boot-maven - generate executable jar (full at)
* surefire, deploy etc - standard maven plugins

## Installation ##
As GitHub doesn't support binary downloads, this will need to be built locally.
All these commands should be run from project root and require maven (3+) and Java 8.

* For executable Jar:
mvn -Penv-prod clean package

> And then run the executable jar via
> java -jar ./target/newsgeek.jar

* For Docker:
mvn -Penv-prod clean package docker:build

> And then not sure as ARM6 on PI 2 does't like Docker 100%
> But will work on it :)

## Reporting bugs ##
Just drop me an email for now until I look into a Trello board or similar

## License ##
Not yet defined

##### *Designed and built on Raspberry Pi v2* #####
