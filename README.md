# ENSAK_MOBILE_APP 

This is a MobileApp of a ENSAK website. 
It uses a restful api to retrieve data, using retrofit library. 

The Webservice is hosted on heroku, and built with Flask, and Scrapy, you can find the details here : 
 * [ENSAK_API](https://github.com/ayoubensalem/ENSAK_API)

Basically, we scrapy data from the website, and render it in the Mobile UI. 
We use SimpleCache for Response Caching with a timeout of 600s, in production you can use Redis.

---

## TODO 

 * Add other information 
 * Implement A Cron Job for scraping every night at 23:00

--- 

## Contributors:

 * Badr Hourimche
 * Charaf Boughriba 
 * Kajja Mohammed 
 * Ayoub ED-DAFALI

