# Kafka
Basics Commands
  1. C:\kafka>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
  2. C:\kafka>bin\windows\kafka-server-start.bat config\server.properties
  3. C:\kafka>bin\windows\kafka-console-consumer.bat --topic kafkaTopic1 --from-beginning --bootstrap-server localhost:9092
  4. C:\kafka>bin\windows\kafka-console-consumer.bat --topic wikimedia_recentchange --from-beginning --bootstrap-server localhost:9092
  5. curl --location 'http://localhost:8080/api/v1/kafka/publish?message=test%20kafka%20message'
  6. curl --location 'http://localhost:8080/api/v1/kafka/publish' \
    --header 'Content-Type: application/json' \
    --data '{
        "id":1,
        "firstName":"Dheeraj",
        "lastName":"Kumar"
    }'
  
  7. https://stream.wikimedia.org/v2/stream/recentchange

# chat-gpt
1. curl --location 'http://localhost:8080/api/chat/ask?prompt=Tell%20me%20a%20joke'
2. curl --location 'localhost:8080/api/chat' \
--header 'Content-Type: text/plain' \
--data 'Explain Spring Boot in simple terms.'
3. curl --location 'localhost:8080/post' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data '{
    "name": "abc",
    "category": "abc",
    "price": 191.0
}'
