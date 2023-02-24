# Speak
A Project that simulates the search process in a social media website . for this i used an elasticsearch database with a postgresql database .
the synchronisation between the two database is secured via requests sent via a kafka topic with the header post or delete

### Kafka 
 Apache Kafka is an open-source distributed event streaming platform . 
#### Main Concepts 
1. Broker : A kafka server
2. Cluster : One or more Kafka Brokers.
3. Topic : A user-defined category to which messages are published.
4. Producer : A process that publishes messages to one or more Kafka topics.
5. Consumer : A process that consumes messages from one or more Kafka topics.
#### How to run on Windows
Kafka can be downloaded from its official site kafka.apache.org
1. Go to the Downloads folder and select the downloaded Binary file
2.  Extract the file and move the extracted folder to the directory where you wish to keep the files.
3. Copy the path of the Kafka folder. Now go to config inside kafka folder and open zookeeper.properties file. Copy the path against the field dataDir and add /zookeeper-data to the path. <br>
!! NOTE : extratct your kafka folder in a small path like D:/ or else you can run into error while running kafka
4. Now in the same folder config open server.properties and scroll down to log.dirs and paste the path. To the path add /kafka-logs
5. open terminal and run 
````
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

````
6. open another terminal and run 

````
.\bin\windows\kafka-server-start.bat .\config\server.properties

````
7. add kafka dependency in project (view project pom.xml)
8. configure topic
9. configure producer
10. configure consumer 
11. send messages using kafkaTemplate

!! NOTE : to serialize and deserialize objects you can use JsonSerializer and JsonDeserializer as shown in .properties file

### Elasticsearch
Elasticsearch is a document based database used widely in search use cases
#### Main concepts 
1. Node : It refers to a single running instance of Elasticsearch
2. Cluser : It is a collection of one or more nodes
3. Document : It is a collection of fields in a specific manner defined in JSON format.
4. Index : It is a collection of different type of documents and their properties
5. Filed : Like a clooumn in a SQL Database

To run elasticsearch just download it from the official site https://www.elastic.co/downloads/elasticsearch . then go to bin folder open terminal and 
run elasticsearch.bat
