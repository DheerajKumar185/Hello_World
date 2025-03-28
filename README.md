C:\kafka>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
C:\kafka>bin\windows\kafka-server-start.bat config\server.properties
C:\kafka>bin\windows\kafka-console-consumer.bat --topic kafkaTopic1 --from-beginning --bootstrap-server localhost:9092
C:\kafka>bin\windows\kafka-console-consumer.bat --topic wikimedia_recentchange --from-beginning --bootstrap-server localhost:9092
curl --location 'http://localhost:8080/api/v1/kafka/publish?message=test%20kafka%20message'
curl --location 'http://localhost:8080/api/v1/kafka/publish' \
--header 'Content-Type: application/json' \
--data '{
    "id":1,
    "firstName":"Dheeraj",
    "lastName":"Kumar"
}'
https://stream.wikimedia.org/v2/stream/recentchange
