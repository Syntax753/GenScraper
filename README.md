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
 
### v0.1 (next release) ###
Top stories fetched from hackernews.com and JSON outputted

## Options ##
> --posts N, -p N
>> number N of stories to fetch. Currently limited to 100 max to avoid abusing their bandwidth

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
