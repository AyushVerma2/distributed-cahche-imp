# distributedcahche 

I assume we have huge amount of data ,so we are going with distributed cache not local.

### Mandatory Fucntion:

 * PUT: (key,value)
 * GET: get value based on key.
 #### Non Mandatory Function:
  * Scalibility
  * Performace
  * Avalibility
 
 - Cache capacity will be limited , so i have used LRU policy to evict data from cache if capcity is full.
   so if any data comes for GET Operaion, it will check in cache:  
      1. IF data present : update the list, put the data at first palce and return the data.
      2. IF data is not there rturn null.
    if data come for put oerations:
     1. it will check if the data is already present , if deleted that and put at first palce (i.e head)
     2. if data is not there, it will check if the  capcity is reached, if it will delete the last data using tail reference.
     3. else it will put data on cache and update the list
      
 * LRU code is there in src folder.
 
 #### To  make it Distributed:
 run the above code on Server Node and, Web service moachine will have to install cache client.
 I have used Consitent hashing for selection of Cache SErver by Cache client,reason i usd this as there will not be any change in
  hashfcuntion , even we add more server node or delete server node based on load.
  
  Now the cache client need to know all server list.
  I have used the Automatice wway for this, i will be using a different confirguration service(USed Zookeeer). where all server node
  will register themself , and it will monitor the health. 
  Cache client will get this information 
  
  Non Functional Consideration:
  * Performance : 
     * LRU implementation will take O(1) for get and put data
     * Cache-clinet will take O(1) to gt Cache Server Info
     * Conneciton used will be TCP
     
  * Scalibilty: as I are using auto-configuration serveice, it will can be scalup or down to by anynumber of node
  * Fail-OveR: for this MAster salve implemention(Leader/Slave) , if LEader get donw ,Leader election will happen.
  * to reduce load on shards ,read(GET) will be allowd on any node (either leader or slave) but put can only happen through master.
  
 ### Advantages –
* It is open for full analysis.
* In this, we replace the page which is least recently used, thus free from   Belady’s Anomaly.
* Easy to choose page which has faulted and hasn’t been used for a long time.
* FIFO in being able to adapt somewhat to the data access pattern; frequently used items are less likely to be ejected from the cache.
* fast, adaptive, not scan resistant
### Disadvantages –
* It requires additional Data Structure to be implemented.
* Hardware assistance is high.
