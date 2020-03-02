# NodeJS

## Problem
 - In MVC architecture, as the number of users increases, the resources needed to maintain the users also needs to be increased(Since all the threads will be exausted).
 
 Most frameworks work on 1 thread per request. Since JS is single threaded, we needed a solution to overcome this problem.
 
 Solution : NodeJS is event-driven. 
 ![Event driven](/NodeJS/SingleThreadedModel.png)

* Only one thread repeatedly does all the processing using queues to process that. So no context switch

