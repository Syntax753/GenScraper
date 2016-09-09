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
TBD

## Reporting bugs ##
Just drop me an email for now until I look into a Trello board or similar

## License ##
Not yet defined

##### *Powered by Raspberry Pi v2* #####
